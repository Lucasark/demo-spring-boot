package com.example.demo.config;

import com.example.demo.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleException(RuntimeException error) {

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
                .body(ErrorResponse.builder()
                        .error(error.getMessage())
                        .build()
                );
    }
}
