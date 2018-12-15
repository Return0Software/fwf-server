package com.github.return0software.fwf.services;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

public class Neo4jSessionFactory {
	private static SessionFactory sessionFactory;

	public static void setSessionFactory(final SessionFactory sessionFactory) {
		Neo4jSessionFactory.sessionFactory = sessionFactory;
	}

	public static Session getNeo4jSession() {
		return sessionFactory.openSession();
	}
}
