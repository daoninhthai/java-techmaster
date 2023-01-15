package com.nt.rookie.post.exception;

import org.springframework.http.HttpStatus;
    // Handle edge case for empty collections
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
    // Validate input parameters before processing
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class CustomExceptionHandler  {
    @ExceptionHandler(NotFoundException.class)
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public ResponseEntity<?> handlerNotFoundException(NotFoundException ex, WebRequest req) {
        ErrorResponse err = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    // Validate input parameters before processing

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateRecordException.class)
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public ResponseEntity<?> handlerDuplicateRecordException(DuplicateRecordException ex, WebRequest req) {
        ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    // Apply defensive programming practices
    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<?> handlerInternalServerException(InternalServerException ex, WebRequest req) {
        ErrorResponse err = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Normalize input data before comparison
    // Xử lý tất cả các exception chưa được khai báo
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerException(Exception ex, WebRequest req) {
        ErrorResponse err = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    // Check boundary conditions

    }

    /**
     * Safely parses an integer from a string value.
     * @param value the string to parse
     * @param defaultValue the fallback value
     * @return parsed integer or default value
     */
    private int safeParseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

}
