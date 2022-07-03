package com.dongko.kodn.member.service

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.dongko.kodn.config.security.JwtTokenProvider
import com.dongko.kodn.member.controller.v1.MemberController
import com.dongko.kodn.member.dto.MemberJoinRequest
import com.dongko.kodn.member.dto.MemberJoinResponse
import com.dongko.kodn.member.entity.Member
import com.dongko.kodn.member.entity.MemberRole
import com.dongko.kodn.member.repository.MemberRepository
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.*
import org.springframework.security.crypto.password.PasswordEncoder

internal class MemberApiServiceTest(
) {
    private lateinit var memberApiService: MemberApiService
    private val memberRepository: MemberRepository = mockk()
    private val memberService: MemberService = mockk()
    private val memberController: MemberController = mockk()
    private val passwordEncoder: PasswordEncoder = mockk()
    private val jwtTokenProvider: JwtTokenProvider = mockk()

    @BeforeEach
    fun setup() {
        clearAllMocks()
        memberApiService = MemberApiService(
            memberService,
            passwordEncoder,
            jwtTokenProvider
        )
    }

    @AfterEach
    fun finish() {
        clearAllMocks()
    }

    @Test
    @DisplayName("name이나 email이 비어있으면 exception 발생한다")
    fun validRequestTest() {
        val stub = MemberJoinRequest("", "email", "password")
        every { memberController.join(stub) } throws Exception()
        assertThrows<Exception> { memberController.join(stub) }
    }

    @Test
    @DisplayName("회원가입 테스트")
    fun joinTest() {
        //given
        val stub = MemberJoinRequest("name", "email", "password")
        val stubMember = Member(stub.name, stub.email, stub.password, mutableSetOf(MemberRole.MEMBER))
        every { memberService.join(stub) } returns MemberJoinResponse(1, stub.name, stub.email)
        every { memberRepository.save(stubMember) } returns stubMember
        every { passwordEncoder.encode("password")} returns ""

        //when
        val memberResponse = memberApiService.join(stub)

        //then
        assertThat(memberResponse)
            .isEqualTo(MemberJoinResponse(1, stub.name, stub.email))
    }
}