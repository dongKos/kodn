package com.dongko.kodn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@EntityScan(basePackages = ["com.dongko.kodn"])
@SpringBootApplication(
    scanBasePackages = ["com.dongko.kodn"]
)
class ApiServerApplication

fun main(args: Array<String>) {
    runApplication<ApiServerApplication>(*args)
}