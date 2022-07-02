package com.dongko.kodn

import com.dongko.kodn.member.entity.Member
import org.springframework.stereotype.Service

@Service
class HomeApiService(
    private val homeService: HomeService
) {
    fun home(): List<Member> = homeService.home()
}