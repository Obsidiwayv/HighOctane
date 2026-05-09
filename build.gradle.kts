plugins {
    id("java")
    id("com.gradleup.shadow") version "9.4.1"
}

group = "wayvlyte.space.octane"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.discord4j:discord4j-core:3.3.2")
    implementation("io.projectreactor.netty:reactor-netty-http:1.2.16")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.21.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.21.0")
    implementation("com.electronwill.night-config:toml:3.8.4")
}

tasks.jar {
    manifest{
        attributes["Main-Class"] = "wayvlyte.space.octane.OctaneClient"
    }
}

tasks.test {
    useJUnitPlatform()
}