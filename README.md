# api-protocolo

## Requirements

For building and running the application you need:

- [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

You can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## See Swagger

http://localhost:8080/swagger-ui.html

## TODO List

1. Connect database. For Now H2 (in memory) for test.
2. Implement Oauth 2 (Keycloak).
3. Make Docker.
5. Build CI/CD.
6. Connect SonarQube (Quality).

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
