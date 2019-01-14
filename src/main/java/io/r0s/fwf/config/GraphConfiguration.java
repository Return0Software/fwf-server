package io.r0s.fwf.config;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	private static final class BoltConfiguration {
		@NotNull
		@JsonProperty
		private Integer port;
	}

	private static final class HttpConfiguration {
		@NotNull
		@JsonProperty
		private Integer port;
	}
}
