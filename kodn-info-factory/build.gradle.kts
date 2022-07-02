import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    idea
    kotlin("plugin.spring")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-validation")
    api(project(":kodn-common"))
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}