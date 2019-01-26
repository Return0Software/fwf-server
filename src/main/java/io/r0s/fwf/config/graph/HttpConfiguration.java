package io.r0s.fwf.config.graph;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("graph.http")
@SuppressWarnings({ "PMD.UnusedPrivateField" })
public class HttpConfiguration {
	private Integer port;

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getPort() {
		return this.port;
	}
}
