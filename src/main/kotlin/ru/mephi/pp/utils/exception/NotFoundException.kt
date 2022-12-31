package ru.mephi.pp.utils.exception

import org.springframework.http.HttpStatus

class NotFoundException(message: String) : ApiException(message, HttpStatus.NOT_FOUND)