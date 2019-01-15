package io.r0s.fwf.config.graph;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
public final class GraphConfiguration {
	@NotNull
	@JsonProperty
	private String host;

	@NotNull
	@JsonProperty
	private String username;

	@NotNull
	@JsonProperty
	private String password;

	@NotNull
	@JsonProperty
	private BoltConfiguration bolt;

	@NotNull
	@JsonProperty
	private HttpConfiguration http;
}
