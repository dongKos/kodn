plugins {
    idea
    kotlin("plugin.spring")
}
repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":kodn-service"))

    implementation("com.nimbusds:nimbus-jose-jwt:6.0.2")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
        exclude(module = "mockito-core")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("com.ninja-squad:springmockk:3.1.1")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
}
tasks.getByName<Jar>("jar") {
    enabled = true
}