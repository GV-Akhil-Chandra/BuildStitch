package com.BuildStitch_monolith.Advice;

import com.BuildStitch_monolith.Exception.BadRequestException;
import com.BuildStitch_monolith.Exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(BadRequestException e){
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, e.getMessage());
        log.error(apiError.toString(), e);

        return ResponseEntity.status(apiError.httpStatus()).body(apiError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException e){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getMessage());
        log.error(apiError.toString(), e);

        return ResponseEntity.status(apiError.httpStatus()).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleInvalidMethodArguments(MethodArgumentNotValidException e){
        var errors = e.getBindingResult().getFieldErrors().stream()
                        .map(error -> new ApiErrorField(error.getField(), error.getDefaultMessage()))
                                .toList();

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Invalid input", errors);
        log.error(apiError.toString(), e);

        return ResponseEntity.status(apiError.httpStatus()).body(apiError);
    }
}
