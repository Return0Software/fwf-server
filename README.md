[![Build Status](https://travis-ci.com/Return0Software/fwf-server.svg?branch=master)](https://travis-ci.com/Return0Software/fwf-server)

# Flix with Friends Server

## Development

### Documentation

* [Dropwizard](https://www.dropwizard.io/1.3.5/docs/manual/index.html)
* [Neo4j OGM](https://neo4j.com/docs/ogm-manual/current/reference/)

### Dependencies

* Java >= 1.8 (any OpenJDK distribution should work)
* Apache Maven (only tested with 3.6)

**Note**: OpenJDK is strongly suggested. This application will never be deployed
with Oracle JDK due to licensing.

#### macOS

Azul Zulu or AdoptOpenJDK should work fine.

```bash
brew cask install zulu8
# or
brew tap AdoptOpenJDK/openjdk
brew cask install adoptopenjdk8
```

#### Linux

Use your package manager to install OpenJDK 8

### Running the Application

```text
mvn exec:java@run
```
