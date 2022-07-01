package com.dongko.kodn

import org.springframework.stereotype.Service

@Service
class HomeService(
    private val memberRepository: MemberRepository
) {
    fun home(): List<Member> = memberRepository.findAll()
}