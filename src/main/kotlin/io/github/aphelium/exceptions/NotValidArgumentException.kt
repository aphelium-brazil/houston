package io.github.aphelium.exceptions

import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.function.Consumer

@ControllerAdvice
class NotValidArgumentException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(
        MethodArgumentNotValidException::class
    )
    @ResponseBody
    fun handleNotValidArgumentException(exception: MethodArgumentNotValidException): Map<String, String?> {
        val errors: MutableMap<String, String?> = HashMap()
        exception.bindingResult.fieldErrors.forEach(Consumer { error: FieldError ->
            errors[error.field] = error.defaultMessage
        })
        return errors
    }
}