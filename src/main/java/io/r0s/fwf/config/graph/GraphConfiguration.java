package io.r0s.fwf.config.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("graph")
@SuppressWarnings({ "PMD.UnusedPrivateField" })
public class GraphConfiguration {
	private final static Logger log = LoggerFactory.getLogger(GraphConfiguration.class);
	private String host;
	private String username;
	private String password;

	@Autowired
	private BoltConfiguration bolt;

	@Autowired
	private HttpConfiguration http;

	public String getHost() {
		return this.host;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public BoltConfiguration getBoltConfiguration() {
		return this.bolt;
	}

	public HttpConfiguration getHttpConfiguration() {
		return this.http;
	}

	public void setHost(final String host) {
		this.host = host;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public void setPassword(final String password) {
		this.password = password;
	}
}
