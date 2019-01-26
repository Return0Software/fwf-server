package io.r0s.fwf.health;

import java.util.Collections;

import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import io.r0s.fwf.factories.Neo4jSessionFactory;

@Component
public final class Neo4jHealthCheck extends AbstractHealthIndicator {
	private final static Logger log = LoggerFactory.getLogger(Neo4jHealthCheck.class);

	private final Session session;

	public Neo4jHealthCheck(final Neo4jSessionFactory sessionFactory) {
		session = sessionFactory.getSession();
	}

	@Override
	protected void doHealthCheck(Health.Builder builder) throws Exception {
		try {
			final Result result = session.query("MATCH (n) COUNT (n) AS nodes", Collections.emptyMap());
			builder.up().withDetail("nodes", result.queryResults().iterator().next().get("nodes"));
		} catch (Exception e) {
			log.error("Neo4j health check failed", e);
			builder.down(e);
		}
	}
}
