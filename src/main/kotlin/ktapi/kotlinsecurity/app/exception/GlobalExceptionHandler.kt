package ktapi.kotlinsecurity.app.exception

import ktapi.kotlinsecurity.app.dto.ErrorResponse
import ktapi.kotlinsecurity.domain.exception.DataAlreadyExistsException
import ktapi.kotlinsecurity.domain.exception.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<ErrorResponse> {
        logger.error("Unhandled exception caught: ", exception)
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val error = ErrorResponse(
            httpStatus = status,
            message = exception.message ?: "An unexpected error occurred"
        )
        return ResponseEntity(error, status)
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException): ResponseEntity<ErrorResponse> {
        logger.error("Not found exception caught: ", exception)
        val status = HttpStatus.NOT_FOUND
        val error = ErrorResponse(
            httpStatus = status,
            message = exception.message ?: "Resource not found"
        )
        return ResponseEntity(error, status)
    }

    @ExceptionHandler(DataAlreadyExistsException::class)
    fun handleDataAlreadyExistsException(exception: DataAlreadyExistsException): ResponseEntity<ErrorResponse> {
        logger.error("Data already exists exception caught: ", exception)
        val status = HttpStatus.CONFLICT
        val error = ErrorResponse(
            httpStatus = status,
            message = exception.message ?: "Data already exists"
        )
        return ResponseEntity(error, status)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(exception: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        logger.error("Illegal argument exception caught: ", exception)
        val status = HttpStatus.BAD_REQUEST
        val error = ErrorResponse(
            httpStatus = status,
            message = exception.message ?: "Invalid argument"
        )
        return ResponseEntity(error, status)
    }
}