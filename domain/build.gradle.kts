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
}

tasks.test {
    useJUnitPlatform()
}
//val mockitoAgent = configurations.create("mockitoAgent")
//dependencies {
//    testImplementation(libs.mockito)
//    mockitoAgent(libs.mockito) { isTransitive = false }
//}
//tasks {
//    test {
//        jvmArgs("-javaagent:${mockitoAgent.asPath}")
//    }
//}