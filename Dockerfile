# Build Stage
FROM maven:3.6.1-jdk-8 AS builder
WORKDIR /Creditcard
COPY pom.xml .
COPY ./src ./src
RUN mvn clean package

# Run Stage
FROM openjdk:8u201-jdk-alpine3.9
LABEL maintainer="Masivian Group"
WORKDIR WORKSPACE /Creditcard
COPY --from=builder /Creditcard/target/spring-soap-1.0.0.jar .
ENTRYPOINT java -Djava.net.preferIPv4Stack=true -jar spring-soap-1.0.0.jar