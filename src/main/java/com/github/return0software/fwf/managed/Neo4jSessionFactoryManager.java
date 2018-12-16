package com.github.return0software.fwf.managed;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import io.dropwizard.lifecycle.Managed;

public class Neo4jSessionFactoryManager implements Managed {
	private static SessionFactory sessionFactory;
	private final Configuration configuration;

	public Neo4jSessionFactoryManager(final Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	public void start() {
		Neo4jSessionFactoryManager.sessionFactory = new SessionFactory(configuration,
				"com.github.return0software.fwf.entities");
	}

	@Override
	public void stop() {
		Neo4jSessionFactoryManager.sessionFactory.close();
	}

	public static Session getNeo4jSession() {
		return Neo4jSessionFactoryManager.sessionFactory.openSession();
	}
}
