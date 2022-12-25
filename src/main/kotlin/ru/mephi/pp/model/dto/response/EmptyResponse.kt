package ru.mephi.pp.model.dto.response

import org.springframework.http.HttpStatus
import ru.mephi.pp.model.dto.ApiResponse
import java.time.LocalDateTime

data class EmptyResponse(
    private val msg: String
) : ApiResponse {
    override val status: HttpStatus = HttpStatus.OK
    override val message: String = msg
    override val timestamp: LocalDateTime = LocalDateTime.now()
}
