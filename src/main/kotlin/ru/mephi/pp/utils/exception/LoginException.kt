package ru.mephi.pp.utils.exception

import org.springframework.http.HttpStatus

class LoginException(msg: String) : AbstractApiException(
    message = msg,
    status = HttpStatus.BAD_REQUEST
)