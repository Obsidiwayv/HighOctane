import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.repositories

plugins {
    id("java")
}

group = "wayvlyte.space.octane"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.discord4j:discord4j-core:3.3.2") {
        exclude("io.projectreactor.netty", "reactor-netty-http")
    }
    implementation("io.projectreactor.netty:reactor-netty-http:1.2.16")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.21.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.21.0")
}

tasks.test {
    useJUnitPlatform()
}