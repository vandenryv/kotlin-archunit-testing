plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.hexavote.domain"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.mockito:mockito-core:+")
    testImplementation("org.mockito.kotlin:mockito-kotlin:+")
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":common"))
    testImplementation("com.tngtech.archunit:archunit:1.3.0")
    testImplementation("com.tngtech.archunit:archunit-junit5:1.3.0")
}

tasks.test {
    useJUnitPlatform()
}
