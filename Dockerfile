FROM maven:3-jdk-8-alpine AS builder
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . .
RUN mvn install

FROM openjdk:8-jre-alpine
ARG version=0.0.1-SNAPSHOT
ENV FWF_VERSION ${version}
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY --from=builder /usr/src/app/target/fwf-${version}.jar /usr/src/app
EXPOSE 8080
CMD ["sh", "-c", "java -jar fwf-${FWF_VERSION}.jar", "-Dspring.profiles.active=docker"]
