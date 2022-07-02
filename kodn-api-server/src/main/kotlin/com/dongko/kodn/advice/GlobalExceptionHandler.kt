package com.dongko.kodn.advice

import com.dongko.kodn.exception.ErrorResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [Exception::class])
    fun excpetion(e: Exception, request: HttpServletRequest): ErrorResponse {
        println("${e.message} at : ${request.requestURL}")
        return ErrorResponse( 500, e.message.toString());
    }
}