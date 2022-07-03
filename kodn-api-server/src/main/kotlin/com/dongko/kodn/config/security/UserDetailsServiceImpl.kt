package com.dongko.kodn.config.security

import com.dongko.kodn.member.entity.Member
import com.dongko.kodn.member.service.MemberService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.User as SpringUser

@Service
class UserDetailsServiceImpl(
    private val memberService: MemberService
) : UserDetailsService{
    override fun loadUserByUsername(name: String): UserDetails {
        val member = memberService.findByName(name).orElseThrow {
            throw IllegalArgumentException()
        }
        return LoginUser(member, member.password)
    }
}

data class LoginUser(
    val member: Member,
    internal val password: String
): SpringUser(member.name, password, listOf())