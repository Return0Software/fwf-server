package com.github.return0software.fwf.managed;

import com.github.return0software.fwf.App;

import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.lifecycle.Managed;

/**
 * Due to the order of events in DropWizard, the Neo4j configuration has to
 * circumvent the configuration file. Guice is setup in
 * {@link App#initialize(io.dropwizard.setup.Bootstrap)}. Because of that, the
 * config variables have not been read in, and subsequently
 * {@link Neo4jSessionFactory#start()} has not been called.
 */
public final class Neo4jSessionFactory implements Managed {
	private final static Logger log = LoggerFactory.getLogger(App.class);

	private static Configuration configuration = new Configuration.Builder(
			new ClasspathConfigurationSource("ogm.properties")).build();

	private static SessionFactory sessionFactory = new SessionFactory(configuration,
			String.format("%s.domain", App.class.getPackage().getName()));

	private static Neo4jSessionFactory factory = new Neo4jSessionFactory();

	@Override
	public void start() {
	}

	/**
	 * Close the session factory on server shutdown.
	 */
	@Override
	public void stop() {
		log.info("Closing the session factory");
		Neo4jSessionFactory.sessionFactory.close();
	}

	public static Neo4jSessionFactory getInstance() {
		return Neo4jSessionFactory.factory;
	}

	/**
	 * @return {@link Session}
	 */
	public static Session getNeo4jSession() {
		return Neo4jSessionFactory.sessionFactory.openSession();
	}
}
