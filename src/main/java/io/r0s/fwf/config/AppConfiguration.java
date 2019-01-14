package io.r0s.fwf.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
public final class AppConfiguration extends Configuration {
	@NotNull
	@Valid
	@JsonProperty("swagger")
	private SwaggerBundleConfiguration swaggerBundleConfiguration = new SwaggerBundleConfiguration();

	@Valid
	@NotNull
	@JsonProperty("jerseyClient")
	private JerseyClientConfiguration jerseyClient = new JerseyClientConfiguration();

	@NotNull
	@Valid
	@JsonProperty("graph")
	private GraphConfiguration graphConfiguration;

	public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
		return this.swaggerBundleConfiguration;
	}

	public JerseyClientConfiguration getJerseyClientConfiguration() {
		return this.jerseyClient;
	}
}
