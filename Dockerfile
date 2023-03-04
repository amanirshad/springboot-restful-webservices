#FROM maven:3.6.3-openjdk-11-slim as BUILDER
#ARG VERSION=0.0.1-SNAPSHOT
#WORKDIR /build/
#COPY pom.xml /build/
#COPY src /build/src/
#
#RUN mvn clean package
#COPY target/springboot-restful-webservices-${VERSION}.jar target/application.jar

FROM openjdk:17
WORKDIR /app/

COPY target/springboot-restful-webservices-0.0.1-SNAPSHOT.jar /app/application.jar
CMD java -jar /app/application.jar