package com.github.return0software.fwf;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import com.github.return0software.fwf.health.Neo4jHealthCheck;
import com.github.return0software.fwf.managed.Neo4jSessionFactoryManager;
import com.github.return0software.fwf.resources.GroupResource;
import com.github.return0software.fwf.resources.UserResource;

import org.neo4j.ogm.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public final class App extends Application<AppConfiguration> {
	private final static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public void run(AppConfiguration configuration, Environment environment) {
		// Connecting to the graph
		log.info("Connecting to the graph");
		final Configuration graphConfig = new Configuration.Builder()
				.uri(String.format("bolt://%s:%d", configuration.getHost(), configuration.getPort()))
				.credentials(configuration.getUsername(), configuration.getPassword()).build();
		Neo4jSessionFactoryManager sessionFactoryManager = new Neo4jSessionFactoryManager(graphConfig);
		environment.lifecycle().manage(sessionFactoryManager);

		// Resources
		log.info("Registering resources");
		final GroupResource groupResource = new GroupResource();
		final UserResource userResource = new UserResource();

		environment.jersey().register(groupResource);
		environment.jersey().register(userResource);

		// Health Checks
		log.info("Registering healthchecks");
		final Client client = ClientBuilder.newClient();
		final Neo4jHealthCheck neo4jHealthCheck = new Neo4jHealthCheck(client, configuration.getHost(),
				configuration.getPort());

		environment.healthChecks().register("Neo4j", neo4jHealthCheck);
	}
}
