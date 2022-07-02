package com.dongko.kodn.member.event

import com.dongko.kodn.member.entity.Member
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionalEventListener

data class MemberJoinEvent(
    val id: Long,
    val name: String,
    val email: String
) {
    companion object {
        operator fun invoke(member: Member) = with(member) {
            MemberJoinEvent(id, name, email)
        }
    }
}

@Component
class MemberEventListener() {

    @TransactionalEventListener
    fun memberJoinEventListener(event: MemberJoinEvent) {
        println(event)
    }
}