package com.dongko.kodn.member.service

import com.dongko.kodn.config.security.JwtTokenProvider
import com.dongko.kodn.member.dto.LoginRequest
import com.dongko.kodn.member.dto.LoginResponse
import com.dongko.kodn.member.dto.MemberJoinRequest
import com.dongko.kodn.member.dto.MemberJoinResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.servlet.http.HttpServletResponse

@Service
class MemberApiService(
    private val memberService: MemberService,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun join(request: MemberJoinRequest) : MemberJoinResponse {
        request.password = passwordEncoder.encode(request.password)
        return memberService.join(request)
    }

    fun login(request: LoginRequest, httpServletResponse: HttpServletResponse): LoginResponse {
        val member = memberService.findByName(request.name).get()
        if(passwordEncoder.matches(request.password, member.password)) {
            httpServletResponse.setHeader("accessToken", jwtTokenProvider.createToken(member.name))
            return LoginResponse(member.id, member.name)
        }
        throw IllegalArgumentException()
    }


}