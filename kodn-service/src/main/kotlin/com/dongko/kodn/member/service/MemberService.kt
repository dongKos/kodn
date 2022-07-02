package com.dongko.kodn.member.service

import com.dongko.kodn.member.dto.MemberJoinRequest
import com.dongko.kodn.member.dto.MemberJoinResponse
import com.dongko.kodn.member.entity.Member
import com.dongko.kodn.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun join(request: MemberJoinRequest) : MemberJoinResponse{
        val member = memberRepository.save(Member(request))
        member.publishJoinEvent(member)
        memberRepository.save(member)
        return MemberJoinResponse(member.id, member.name, member.email)
    }
}