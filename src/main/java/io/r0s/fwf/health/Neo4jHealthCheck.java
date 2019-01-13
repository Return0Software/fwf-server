package io.r0s.fwf.health;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.vyarus.dropwizard.guice.module.installer.feature.health.NamedHealthCheck;
import ru.vyarus.dropwizard.guice.module.yaml.bind.Config;

public final class Neo4jHealthCheck extends NamedHealthCheck {
	private final static Logger log = LoggerFactory.getLogger(Neo4jHealthCheck.class);

	private final Client client;

	@Inject
	@Config("graph.host")
	private String host;

	@Inject
	@Config("graph.port")
	private Integer port;

	@Inject
	@Config("graph.username")
	private String username;

	@Inject
	@Config("graph.password")
	private String password;

	private final String url;

	public Neo4jHealthCheck() {
		this.client = ClientBuilder.newClient();
		this.url = String.format("http://%s:%d", this.host, this.port);
		log.info("URL: {}", this.url);
	}

	@Override
	protected Result check() throws Exception {
		Optional<Response> response = Optional.ofNullable(
				client.target(this.url).request(MediaType.APPLICATION_JSON).buildGet().invoke(Response.class));
		if (response.isPresent()) {
			Response r = response.get();
			if (r.bolt == null || r.management == null || r.data == null) {
				return Result.unhealthy(String.format("Unexpected response from Neo4j server (%s)", this.url));
			}

			return Result.healthy();
		}

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
