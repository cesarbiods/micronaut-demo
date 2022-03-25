# Micronaut/GraalVM proof of concept

This project served as an experiment to determine the feasibility of moving our spring services to micronaut to leverage
GraalVM's native image mode. Having used JPA/Hibernate, kafka, and Jackson it was deemed sufficient and so the source
code lies here as a reference for converting future services/libraries.

## Stack

- Micronaut
- Kotlin
- Gradle (kotlin)
- Logback
- Jackson
- Jpa/Hibernate
- Kafka
- Yaml properties
- GraalVM JVM and native image modes

## How to Run

1. Execute gradle task `dockerBuildNative`
2. `docker-compose up`
