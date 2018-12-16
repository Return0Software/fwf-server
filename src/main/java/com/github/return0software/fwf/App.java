package com.github.return0software.fwf;

import com.github.return0software.fwf.health.DefaultHealthCheck;
import com.github.return0software.fwf.managed.Neo4jSessionFactoryManager;
import com.github.return0software.fwf.resources.GroupResource;
import com.github.return0software.fwf.resources.UserResource;

import org.neo4j.ogm.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public final class App extends Application<AppConfiguration> {
	private static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
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
		final DefaultHealthCheck defaultHealthCheck = new DefaultHealthCheck();

		environment.healthChecks().register("default", defaultHealthCheck);
	}
}
