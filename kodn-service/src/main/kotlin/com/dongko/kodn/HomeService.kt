package com.dongko.kodn

import com.dongko.kodn.member.entity.Member
import com.dongko.kodn.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class HomeService(
    private val memberRepository: MemberRepository
) {
    fun home(): List<Member> = memberRepository.findAll()
}