package com.dongko.kodn.member.repository

import com.dongko.kodn.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MemberRepository : JpaRepository<Member, Long>{
    fun findByName(name: String): Optional<Member>
}