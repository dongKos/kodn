package com.dongko.kodn

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Member(
    @Id @GeneratedValue
    val id: Long,
    val name: String
) {
}