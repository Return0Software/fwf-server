package io.r0s.fwf.config;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class GraphConfiguration {
	@NotNull
	@JsonProperty
	private String host;

	@NotNull
	@JsonProperty
	private Integer port;

	@NotNull
	@JsonProperty
	private String username;

	@NotNull
	@JsonProperty
	private String password;
}
