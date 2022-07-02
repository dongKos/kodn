package com.dongko.kodn

import com.dongko.kodn.member.entity.Member
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController(
    private val homeApiService: HomeApiService
) {
    @GetMapping
    fun helloWorld(): List<Member> = homeApiService.home()
}