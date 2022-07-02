import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
}

dependencies {
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}
