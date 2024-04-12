package org.sir.erplain.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.sir.erplain.zutils.exception.ApiError;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundExceptionExceptions(NotFoundException e) {
        var error = new ApiError(e.getMessage(), e.getStatus());
        return ResponseEntity
                .status(error.getStatus())
                .body(error);
    }
}
