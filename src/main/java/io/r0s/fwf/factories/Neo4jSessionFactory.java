package io.r0s.fwf.factories;

import javax.annotation.PreDestroy;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.r0s.fwf.App;
import io.r0s.fwf.config.graph.GraphConfiguration;

@Component
public final class Neo4jSessionFactory {
	private final static Logger log = LoggerFactory.getLogger(Neo4jSessionFactory.class);

	private final SessionFactory sessionFactory;

	public Neo4jSessionFactory(final GraphConfiguration graphConfiguration) {
		log.debug("Creating session factory");
		final Configuration configuration = new Configuration.Builder().uri(String.format("bolt://%s:%d", graphConfiguration.getHost(), graphConfiguration.getBoltConfiguration().getPort()))
				.credentials(graphConfiguration.getUsername(), graphConfiguration.getPassword()).build();
		this.sessionFactory = new SessionFactory(configuration,
				String.format("%s.domain", App.class.getPackage().getName()));
	}

	/**
	 * @return {@link Session}
	 */
	public Session getSession() {
		return this.sessionFactory.openSession();
	}

	@PreDestroy
	public void close() {
		log.debug("Closing session factory");
		this.sessionFactory.close();
	}
}
