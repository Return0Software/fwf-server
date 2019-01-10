package io.r0s.fwf;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.r0s.fwf.config.AppConfiguration;
import io.r0s.fwf.health.Neo4jHealthCheck;
import io.r0s.fwf.managed.Neo4jSessionFactory;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.dropwizard.guice.GuiceBundle.Builder;

public final class App extends Application<AppConfiguration> {
	private final static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
		// Allow environment variable overrides
		// https://www.dropwizard.io/1.3.5/docs/manual/core.html#environment-variables
		final SubstitutingSourceProvider envSourceProvider = new SubstitutingSourceProvider(
				bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false));
		bootstrap.setConfigurationSourceProvider(envSourceProvider);

		final String packageName = App.class.getPackage().getName();
		final Builder<AppConfiguration> builder = GuiceBundle.builder();
		final GuiceBundle<AppConfiguration> guiceBundle = builder
				.enableAutoConfig(String.format("%s.resources", packageName), String.format("%s.services", packageName))
				.build();
		bootstrap.addBundle(guiceBundle);
	}

	@Override
	public void run(AppConfiguration configuration, Environment environment) {
		// Connecting to the graph
		log.info("Connecting to the graph");
		environment.lifecycle().manage(Neo4jSessionFactory.getInstance());

		// Health Checks
		log.info("Registering healthchecks");
		final Client client = ClientBuilder.newClient();
		final Neo4jHealthCheck neo4jHealthCheck = new Neo4jHealthCheck(client, configuration.getGraphConfig().getHost(),
				configuration.getGraphConfig().getPort());

		environment.healthChecks().register("Neo4j", neo4jHealthCheck);
	}
}
