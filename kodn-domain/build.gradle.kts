import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
}

dependencies {
    api(project(":kodn-info-factory"))
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}
