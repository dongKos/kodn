package com.dongko.kodn.member.repository

import com.dongko.kodn.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>{
}