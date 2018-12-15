package com.github.return0software.fwf;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public final class AppConfiguration extends Configuration {
	@JsonProperty
	private String graphHost;

	@JsonProperty
	private Integer graphPort;

	@JsonProperty
	private String graphUsername;

	@JsonProperty
	private String graphPassword;

	public String getHost() {
		return this.graphHost;
	}

	public int getPort() {
		return this.graphPort;
	}

	public String getUsername() {
		return this.graphUsername;
	}

	public String getPassword() {
		return this.graphPassword;
	}
}
