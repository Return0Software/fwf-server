package io.r0s.fwf.modules;

import javax.ws.rs.client.Client;

import com.google.inject.name.Names;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.client.JerseyClientBuilder;
import io.r0s.fwf.App;
import io.r0s.fwf.config.AppConfiguration;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class HttpClientModule extends DropwizardAwareModule<AppConfiguration> {
	private static final Logger log = LoggerFactory.getLogger(HttpClientModule.class);

	@Override
	protected void configure() {
		log.info("Configuring JerseyClient");
		this.bind(Client.class).annotatedWith(Names.named("JerseyClient"))
				.toInstance(new JerseyClientBuilder(this.environment())
						.using(this.configuration().getJerseyClientConfiguration()).build(App.class.getSimpleName()));
	}
}
