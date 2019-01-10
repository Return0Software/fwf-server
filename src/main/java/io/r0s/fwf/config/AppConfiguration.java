package io.r0s.fwf.config;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public final class AppConfiguration extends Configuration {
	@NotNull
	@JsonProperty("graph")
	private GraphConfiguration graphConfig;

	public GraphConfiguration getGraphConfig() {
		return this.graphConfig;
	}
}
