package io.r0s.fwf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.r0s.fwf.config.AppConfiguration;
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

		final Builder<AppConfiguration> builder = GuiceBundle.builder();
		final GuiceBundle<AppConfiguration> guiceBundle = builder.enableAutoConfig(App.class.getPackage().getName())
				.build();
		bootstrap.addBundle(guiceBundle);

		// enable swagger
		// bootstrap.addBundle(new SwaggerBundle<AppConfiguration>() {
		// @Override
		// protected SwaggerBundleConfiguration
		// getSwaggerBundleConfiguration(AppConfiguration configuration) {
		// return configuration.getSwaggerBundleConfiguration();
		// }
		// });
	}

	@Override
	public void run(AppConfiguration configuration, Environment environment) {
	}
}
