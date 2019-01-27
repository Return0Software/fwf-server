package io.r0s.fwf.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.neo4j.ogm.model.QueryStatistics;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.r0s.fwf.factories.Neo4jSessionFactory;

@Component
public final class LoadTestDataCommand implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(LoadTestDataCommand.class);

	private final Session session;

	public LoadTestDataCommand(Neo4jSessionFactory sessionFactory) {
		this.session = sessionFactory.getSession();
	}

	@Override
	@SuppressWarnings({ "PMD.PositionLiteralsFirstInComparisons" })
	public void run(String... args) {
		for (String arg : args) {
			if (arg.equals("load-test-data")) {
				log.info("Starting test data load");
				try {
					final String cql = new String(Files.readAllBytes(Paths.get(LoadTestDataCommand.class
							.getClassLoader().getResource("db/FlixWithFriends.cql").getFile())));
					final QueryStatistics stats = session.query(cql, null).queryStatistics();
					log.info("Test data was loaded\n\t{} nodes created\n\t{} relationships created",
							stats.getNodesCreated(), stats.getRelationshipsCreated());
					System.exit(0);
				} catch (IOException e) {
					log.error("Unable to open test data file", e);
				}
			}
		}
	}
}
