package com.example.demo.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.DTO.ApiErrorDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex,  jakarta.servlet.http.HttpServletRequest request) {
        
       ApiErrorDTO error = new ApiErrorDTO(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getBindingResult().getFieldError().getDefaultMessage(),
                request.getRequestURI());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);

    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> handleProductNotFound(ProductNotFoundException ex,
            jakarta.servlet.http.HttpServletRequest request) {

        ApiErrorDTO error = new ApiErrorDTO(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

}
