package com.dongko.kodn.member.service

import com.dongko.kodn.member.dto.MemberJoinRequest
import com.dongko.kodn.member.dto.MemberJoinResponse
import org.springframework.stereotype.Service

@Service
class MemberApiService(
    private val memberService: MemberService,
) {
    fun join(request: MemberJoinRequest) : MemberJoinResponse = memberService.join(request)

}