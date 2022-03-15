FROM openjdk:8-jdk-alpine
RUN mkdir -p /src/api
WORKDIR /src/api
COPY target/*.jar api.jar
ENTRYPOINT java -jar api.jar