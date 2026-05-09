FROM gradle:9.5-jdk25-noble
COPY --chown=gradle:gradle . /home/gradle/src/
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM eclipse-temurin:25-jre-noble
ENTRYPOINT ["java", "-jar", "build/libs/HighOctane-1.0-all.jar"]