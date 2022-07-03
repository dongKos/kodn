package com.dongko.kodn.member.controller.v1

import com.dongko.kodn.member.dto.LoginRequest
import com.dongko.kodn.member.dto.LoginResponse
import com.dongko.kodn.member.service.MemberApiService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
class LoginController(
    private val memberApiService: MemberApiService
) {
    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest, httpServletResponse: HttpServletResponse): ResponseEntity<LoginResponse> {
        return ResponseEntity.ok(memberApiService.login(request, httpServletResponse))
    }
}