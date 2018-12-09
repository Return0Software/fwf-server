package com.github.return0software.fwf;

import com.github.return0software.fwf.health.DefaultHealthCheck;
import com.github.return0software.fwf.resources.GroupResource;
import com.github.return0software.fwf.resources.UserResource;

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
		// Resources
		final GroupResource groupResource = new GroupResource();
		final UserResource userResource = new UserResource();

		environment.jersey().register(groupResource);
		environment.jersey().register(userResource);

		// Health Checks
		final DefaultHealthCheck defaultHealthCheck = new DefaultHealthCheck();

		environment.healthChecks().register("default", defaultHealthCheck);
	}
}
