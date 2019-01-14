package io.r0s.fwf.health;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.name.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.vyarus.dropwizard.guice.module.installer.feature.health.NamedHealthCheck;
import ru.vyarus.dropwizard.guice.module.yaml.bind.Config;

public final class Neo4jHealthCheck extends NamedHealthCheck {
	private final static Logger log = LoggerFactory.getLogger(Neo4jHealthCheck.class);

	private final Client client;
	private final String url;

	@Inject
	public Neo4jHealthCheck(@Named("JerseyClient") final Client client, @Config("graph.host") final String host,
			@Config("graph.http.port") final Integer port) {
		this.url = String.format("http://%s:%d", host, port);
		this.client = client;
	}

	@Override
	protected Result check() throws Exception {
		log.info("Neo4j health check in progress");
		Optional<Response> response = Optional.ofNullable(
				client.target(this.url).request(MediaType.APPLICATION_JSON).buildGet().invoke(Response.class));
		if (response.isPresent()) {
			Response r = response.get();
			if (r.bolt == null || r.management == null || r.data == null) {
				log.info("Neo4j is unhealthy");
				return Result.unhealthy(String.format("Unexpected response from Neo4j server (%s)", this.url));
			}

			log.info("Neo4j is healthy");
			return Result.healthy();
		}

		log.info("Neo4j is unhealthy");
		return Result.unhealthy(String.format("No response from Neo4j server (%s)", this.url));
	}

	@Override
	public String getName() {
		return "neo4j";
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	private static final class Response {
		@JsonProperty
		public String data;

		@JsonProperty
		public String management;

		@JsonProperty
		public String bolt;
	}
}
