package com.dongko.kodn.member.controller.v1

import com.dongko.kodn.member.dto.MemberJoinRequest
import com.dongko.kodn.member.dto.MemberJoinResponse
import com.dongko.kodn.member.service.MemberApiService
import org.slf4j.LoggerFactory
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/member")
@Validated
class MemberController(
    private val memberApiService: MemberApiService
) {
    private val log = LoggerFactory.getLogger("MemberController")

    @PostMapping
    fun join(@Validated @RequestBody request: MemberJoinRequest): MemberJoinResponse {
        log.info("[member] - join : {}", request)
        return memberApiService.join(request)
    }
}