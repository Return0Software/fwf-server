package io.r0s.fwf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
@EnableNeo4jRepositories("io.r0s.fwf.repositories")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
