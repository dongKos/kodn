package com.dongko.kodn.member.entity

import com.dongko.kodn.audit.BaseEntity
import com.dongko.kodn.member.event.MemberJoinEvent
import javax.persistence.*

@Entity
data class Member(
    @Column(unique = true)
    val name: String,
    @Column(unique = true)
    val email: String,
    val password: String,
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    var roles: MutableSet<MemberRole>
): BaseEntity<Member>() {
    @Id @GeneratedValue
    val id: Long = 0

    fun publishJoinEvent(member: Member) {
        registerEvent(MemberJoinEvent(member))
    }
}