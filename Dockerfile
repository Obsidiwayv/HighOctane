FROM gradle:9.5-jdk25-noble AS build
COPY --chown=gradle:gradle . /home/gradle/src/
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM eclipse-temurin:25-jre-noble
WORKDIR /app
COPY --from=build /home/gradle/src/build/lib/HighOctane-1.0-all.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]