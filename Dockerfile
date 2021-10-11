FROM alpine:3.12

LABEL "maintainer"="Gencdevops <gencdevops> "
LABEL "description"="Book Store App"

RUN apk update && \
    apk add openjdk11

ARG APP=app.jar
ENV APPDIR /app
WORKDIR ${APPDIR}


ADD target/book-store-0.0.1-SNAPSHOT.jar ${APP}

CMD ["java", "-jar", "app.jar"]
