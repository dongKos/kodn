package com.dongko.kodn.member.dto

import javax.validation.constraints.NotBlank

data class MemberJoinRequest(
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val email: String,
)
