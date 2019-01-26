package io.r0s.fwf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import io.r0s.fwf.config.graph.GraphConfiguration;

@Configuration
@SuppressWarnings({ "PMD.UnusedPrivateField" })
public class AppConfiguration {
	@Autowired
	private GraphConfiguration graph;

	public GraphConfiguration getGraphConfiguration() {
		return this.graph;
	}
}
