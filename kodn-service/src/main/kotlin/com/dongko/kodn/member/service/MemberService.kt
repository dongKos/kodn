package com.dongko.kodn.member.service

import com.dongko.kodn.member.dto.MemberJoinRequest
import com.dongko.kodn.member.dto.MemberJoinResponse
import com.dongko.kodn.member.entity.Member
import com.dongko.kodn.member.entity.MemberRole
import com.dongko.kodn.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {
    fun join(request: MemberJoinRequest) : MemberJoinResponse{
        val member = memberRepository.save(Member(
            request.name,
            request.email,
            request.password,
            mutableSetOf(MemberRole.MEMBER)
        ))
        member.publishJoinEvent(member)
        memberRepository.save(member)
        return MemberJoinResponse(member.id, member.name, member.email)
    }

    fun findByName(name: String): Optional<Member> = memberRepository.findByName(name)
}