package io.r0s.fwf.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public final class AppConfiguration extends Configuration {
	@NotNull
	@Valid
	@JsonProperty("swagger")
	private SwaggerBundleConfiguration swaggerBundleConfiguration;

	@NotNull
	@Valid
	@JsonProperty("graph")
	private GraphConfiguration graphConfiguration;

	public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
		return this.swaggerBundleConfiguration;
	}
}
