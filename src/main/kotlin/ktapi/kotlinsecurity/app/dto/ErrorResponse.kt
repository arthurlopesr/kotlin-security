package ktapi.kotlinsecurity.app.dto

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ErrorResponse(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val code: Int,
    val status: String,
    val message: String
) {
    constructor(httpStatus: HttpStatus, message: String) : this(
        code = httpStatus.value(),
        status = httpStatus.name,
        message = message
    )
}