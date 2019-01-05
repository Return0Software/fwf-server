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
mvn compile
mvn pmd:check
mvn test
mvn exec:java@run # if necessary
```

At this point, make a commit, and head over to GitHub to create a PR where a
maintainer will review your PR, and submit feedback if necessary.

## 3rd Party Documentation

* [Dropwizard](https://www.dropwizard.io/1.3.5/docs/manual/index.html)
* [Neo4j OGM](https://neo4j.com/docs/ogm-manual/current/reference/)
* [PMD](https://pmd.github.io/)

## Static Code Analysis

This codebase uses PMD to notify developers of possible erronious code, and
Java best practices. Static code analysis must pass in order for pull requests
to be accpeted.
