package com.dongko.kodn.member.entity

import com.dongko.kodn.audit.BaseEntity
import com.dongko.kodn.member.dto.MemberJoinRequest
import com.dongko.kodn.member.event.MemberJoinEvent
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Member(
    @Column(unique = true)
    val name: String,
    @Column(unique = true)
    val email: String,
): BaseEntity<Member>() {
    @Id @GeneratedValue
    val id: Long = 0

    companion object {
        operator fun invoke(memberJoinRequest: MemberJoinRequest) = with(memberJoinRequest) {
            Member(name, email)
        }
    }

    fun publishJoinEvent(member: Member) {
        registerEvent(MemberJoinEvent(member))
    }
}