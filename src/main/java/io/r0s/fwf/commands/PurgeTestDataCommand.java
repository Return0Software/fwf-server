package io.r0s.fwf.commands;

import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.r0s.fwf.factories.Neo4jSessionFactory;

@Component
public final class PurgeTestDataCommand implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(LoadTestDataCommand.class);

	private final Session session;

	public PurgeTestDataCommand(Neo4jSessionFactory sessionFactory) {
		this.session = sessionFactory.getSession();
	}

	@Override
	@SuppressWarnings({ "PMD.PositionLiteralsFirstInComparisons" })
	public void run(String... args) {
		for (String arg : args) {
			if (arg.equals("purge-test-data")) {
				log.info("Starting test data purge");
				session.purgeDatabase();
				log.info("Test data was purged");
				System.exit(0);
			}
		}
	}
}
