FROM alpine:3.12

LABEL "maintainer"="Gencdevops <gencdevops> "
LABEL "description"="Book Store App"

RUN apk update && apk add openjdk11

ARG APP=app.jar
WORKDIR /app

COPY target/book-store-0.0.1-SNAPSHOT.jar ${APP}

ENTRYPOINT ["java", "-jar", "app.jar"]