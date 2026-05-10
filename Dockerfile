FROM gradle:9.5-jdk25-noble AS build
COPY --chown=gradle:gradle . /home/gradle/src/
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM eclipse-temurin:25-jre-noble
WORKDIR /pantheon
COPY --from=build /home/gradle/src/build/libs/HighOctane-Apex.jar app.jar
COPY --from=build /home/gradle/src/client.config.toml client.config.toml