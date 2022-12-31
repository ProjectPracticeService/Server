package ru.mephi.pp.utils.advice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import ru.mephi.pp.utils.exception.ApiException

@ControllerAdvice
class ExceptionAdvice {
    @ExceptionHandler(value = [ApiException::class])
    fun handle(ex: ApiException, request: WebRequest): ResponseEntity<String> {
        return ResponseEntity.status(ex.status).body(ex.message)
    }

    @ExceptionHandler(value = [Exception::class])
    fun handle(ex: Exception, request: WebRequest): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.message)
    }
}