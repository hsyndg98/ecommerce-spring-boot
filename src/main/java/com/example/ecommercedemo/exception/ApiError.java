package com.example.ecommercedemo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Getter
public class ApiError {
    private final HttpStatus status;
    private final String message;
    private final List<String> error;

    public ApiError(HttpStatus status, String message, List<String> error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public ApiError(HttpStatus status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = Arrays.asList(error);
    }
}
