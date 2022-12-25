package ru.mephi.pp.utils.exception

import org.springframework.http.HttpStatus

class NotFoundException : AbstractApiException(
    message = "Not Found!",
    status = HttpStatus.NOT_FOUND
)