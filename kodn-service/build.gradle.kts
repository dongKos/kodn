import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
}

dependencies {
    api(project(":kodn-domain"))
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}