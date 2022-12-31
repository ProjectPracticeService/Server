package ru.mephi.pp.utils.exception

import org.springframework.http.HttpStatus

abstract class ApiException(
    override val message: String,
    val status: HttpStatus
) : Exception()
