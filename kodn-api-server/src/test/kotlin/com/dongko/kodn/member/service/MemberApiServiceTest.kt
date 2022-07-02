package com.dongko.kodn.member.service

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.dongko.kodn.member.controller.MemberController
import com.dongko.kodn.member.dto.MemberJoinRequest
import com.dongko.kodn.member.dto.MemberJoinResponse
import com.dongko.kodn.member.entity.Member
import com.dongko.kodn.member.repository.MemberRepository
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MemberApiServiceTest(
) {
    private lateinit var memberApiService: MemberApiService
    private val memberRepository: MemberRepository = mockk()
    private val memberService: MemberService = mockk()
    private val memberController: MemberController = mockk()

    @BeforeEach
    fun setup() {
        clearAllMocks()
        memberApiService = MemberApiService(
            memberService
        )
    }

    @Test
    @DisplayName("name이나 email이 비어있으면 exception 발생한다")
    fun validRequestTest() {
        val stub = MemberJoinRequest("", "email")
        every { memberController.join(stub) } throws Exception()
        assertThrows<Exception> { memberController.join(stub) }
    }

    @Test
    @DisplayName("회원가입 테스트")
    fun joinTest() {
        //given
        val stub = MemberJoinRequest("name", "email")
        every { memberService.join(stub) } returns MemberJoinResponse(1, stub.name, stub.email)
        every { memberRepository.save(Member.invoke(stub)) } returns Member.invoke(stub)

        //when
        val memberResponse = memberApiService.join(MemberJoinRequest("name", "email"))

        //then
        assertThat(memberResponse)
            .isEqualTo(MemberJoinResponse(1, stub.name, stub.email))
    }
}