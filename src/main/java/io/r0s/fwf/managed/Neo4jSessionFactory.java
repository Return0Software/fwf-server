package io.r0s.fwf.managed;

import javax.inject.Inject;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.lifecycle.Managed;
import io.r0s.fwf.App;
import ru.vyarus.dropwizard.guice.module.yaml.bind.Config;

/**
 * Due to the order of events in DropWizard, the Neo4j configuration has to
 * circumvent the configuration file. Guice is setup in
 * {@link App#initialize({@link io.dropwizard.setup.Bootstrap})}. Because of
 * that, the config variables have not been read in, and subsequently
 * {@link Neo4jSessionFactory#start()} has not been called.
 */
public final class Neo4jSessionFactory implements Managed {
	private final static Logger log = LoggerFactory.getLogger(Neo4jSessionFactory.class);

	@Inject
	@Config("graph.host")
	private static String host;

	@Inject
	@Config("graph.port")
	private static Integer port;

	@Inject
	@Config("graph.username")
	private static String username;

	@Inject
	@Config("graph.password")
	private static String password;

	private static final Configuration configuration = new Configuration.Builder()
			.uri(String.format("bolt://%s:%d", host, port)).credentials(username, password).build();

	private static final SessionFactory sessionFactory = new SessionFactory(configuration,
			String.format("%s.domain", App.class.getPackage().getName()));

	private static final Neo4jSessionFactory factory = new Neo4jSessionFactory();

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
