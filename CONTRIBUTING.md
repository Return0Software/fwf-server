# Contributing

Open issues and feature requests are available for any developer to tackle.

## Setting up Development Environment

1. Fork this repository on GitHub
2. Clone your fork
3. Install Java 1.8, Maven, Docker, and `docker-compose` for your system
4. Run `docker-compose up -d neo4j` in the root of the project

After getting all of this setup, you are ready to develop. Once you have made
your contributions to the code, go through the following commands:

```text
mvn pmd:check
mvn test
mvn spring-boot:run # if necessary
```

At this point, make a commit, and head over to GitHub to create a PR where a
maintainer will review your PR, and submit feedback if necessary.

### Docker

This project has extensive support for Docker-based workflows. If you do not
want to develop on your machine you are more than welcome to use the `fwf`
service in the `docker-compose-dev.yml` file.

The source code is mounted into the image so it updates as you update it in
your editor.

> I recommend tunneling into the image and using the command line from
> there in order to have access to `mvn`. Make sure you include the
> `docker` profile when launching Spring Boot
> (`-Dspring.profiles.includes=docker) - @tristan957

### Admin Client

This project has setup a Spring Boot admin client located at
http://localhost:8080/gateway for your convenience.

## 3rd Party Documentation

* [Spring](http://spring.io/projects/spring-boot)
* [Neo4j OGM](https://neo4j.com/docs/ogm-manual/current/reference/)
* [Spring Data Neo4j](https://neo4j.com/developer/spring-data-neo4j/)
* [PMD](https://pmd.github.io/)

## Static Code Analysis

This codebase uses PMD to notify developers of possible erronious code, and
Java best practices. Static code analysis must pass in order for pull requests
to be accpeted.
