FROM todocoder/jre:17
LABEL authors="harenk"
WORKDIR /opt

ARG PORT=1337

EXPOSE ${PORT}

ENV APP_BASE_URL="http://localhost:${PORT}/api"
ENV APP_ARGS="-XX:+UseG1GC -Xms1024m -Xmx1024m -Xss256k -XX:MetaspaceSize=128m"

COPY ./app.jar app.jar
COPY ./database.db database.db

ENTRYPOINT ["java", "-jar", "app.jar", "${APP_ARGS}", "--spring.profiles.active=sqlite", "-c"]
