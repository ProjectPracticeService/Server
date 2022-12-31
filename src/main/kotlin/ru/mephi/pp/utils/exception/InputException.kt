package ru.mephi.pp.utils.exception

import org.springframework.http.HttpStatus

class InputException(message: String) : ApiException(message, HttpStatus.BAD_REQUEST)