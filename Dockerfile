FROM openjdk:11

LABEL "maintainer"="Gencdevops <gencdevops> "
LABEL "description"="Book Store App"

WORKDIR /app

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
