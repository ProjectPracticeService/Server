package ru.mephi.pp.utils.exception

import org.springframework.http.HttpStatus

class SignupException(msg: String) : AbstractApiException(
    message = msg,
    status = HttpStatus.CONFLICT
)