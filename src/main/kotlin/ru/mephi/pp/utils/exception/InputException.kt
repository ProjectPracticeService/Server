package ru.mephi.pp.utils.exception

import org.springframework.http.HttpStatus

class InputException(message: String) : AbstractApiException(
    message = message,
    status = HttpStatus.BAD_REQUEST
)