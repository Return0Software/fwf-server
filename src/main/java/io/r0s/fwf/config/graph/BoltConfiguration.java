package io.r0s.fwf.config.graph;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
public final class BoltConfiguration {
	@NotNull
	@JsonProperty
	private Integer port;
}
