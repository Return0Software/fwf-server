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
 * circumvent the normal {@link Managed} way of things. Guice creates its
 * injectables before DropWizard ever calls {@link Managed#start()}.
 */
public final class Neo4jSessionFactory implements Managed {
	private final static Logger log = LoggerFactory.getLogger(Neo4jSessionFactory.class);

	private SessionFactory sessionFactory;

	@Inject
	public Neo4jSessionFactory(@Config("graph.host") final String host, @Config("graph.bolt.port") final Integer port,
			@Config("graph.username") final String username, @Config("graph.password") final String password) {
		log.info("Creating session factory");
		final Configuration configuration = new Configuration.Builder().uri(String.format("bolt://%s:%d", host, port))
				.credentials(username, password).build();
		this.sessionFactory = new SessionFactory(configuration,
				String.format("%s.domain", App.class.getPackage().getName()));
	}

	/**
	 * Starts the session factory on server startup
	 */
	@Override
	public void start() {
	}

	/**
	 * Closes the session factory on server shutdown
	 */
	@Override
	public void stop() {
		log.info("Closing session factory");
		this.sessionFactory.close();
	}

	/**
	 * @return {@link Session}
	 */
	public Session getNeo4jSession() {
		return this.sessionFactory.openSession();
	}
}
