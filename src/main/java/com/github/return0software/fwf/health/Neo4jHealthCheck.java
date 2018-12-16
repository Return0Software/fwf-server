package com.github.return0software.fwf.health;

import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.health.HealthCheck;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Neo4jHealthCheck extends HealthCheck {
	private final Client client;
	private final String url;

	public Neo4jHealthCheck(final Client client, final String host, final int port) {
		this.client = client;
		this.url = String.format("http://%s:%d", host, port);
	}

	@Override
	protected Result check() throws Exception {
		Optional<Response> response = Optional
				.ofNullable(client.target(url).request(MediaType.APPLICATION_JSON).buildGet().invoke(Response.class));
		if (response.isPresent()) {
			Response r = response.get();
			if (r.bolt == null || r.management == null || r.data == null) {
				return Result.unhealthy(String.format("Unexpected response from Neo4j server (%s)", this.url));
			}

			return Result.healthy();
		}

		return Result.unhealthy(String.format("No response from Neo4j server (%s)", this.url));
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class Response {
		@JsonProperty
		public String data;

		@JsonProperty
		public String management;

		@JsonProperty
		public String bolt;
	}
}
