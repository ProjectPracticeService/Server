package ru.mephi.pp.utils.exception

import org.springframework.http.HttpStatus

class AccessException(message: String) : ApiException(message, HttpStatus.FORBIDDEN)