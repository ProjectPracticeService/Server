package ru.mephi.pp.utils.exception

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.http.HttpStatus
import ru.mephi.pp.model.dto.ApiResponse
import java.time.LocalDateTime

@JsonIgnoreProperties("cause", "stackTrace", "suppressed", "localizedMessage")
abstract class AbstractApiException(
    override val status: HttpStatus,
    override val message: String
): ApiResponse, Exception() {
    override val timestamp: LocalDateTime = LocalDateTime.now()
}