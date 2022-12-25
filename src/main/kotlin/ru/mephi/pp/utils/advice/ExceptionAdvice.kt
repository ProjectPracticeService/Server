package ru.mephi.pp.utils.advice

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import ru.mephi.pp.utils.exception.AbstractApiException

@ControllerAdvice
class ExceptionAdvice {
    @ExceptionHandler(value = [AbstractApiException::class])
    fun handle(cause: AbstractApiException, request: WebRequest) = cause.asResponse()
}