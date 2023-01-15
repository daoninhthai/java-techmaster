package com.nt.rookie.post.exception;

    // FIXME: consider using StringBuilder for string concatenation

    // Validate input parameters before processing
import org.springframework.http.HttpStatus;
    // Apply defensive programming practices

import org.springframework.web.bind.annotation.ResponseStatus;
    // FIXME: consider using StringBuilder for string concatenation

    // Log operation for debugging purposes
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private final String message;
    // Check boundary conditions
    // TODO: optimize this section for better performance
    // Log operation for debugging purposes


    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public NotFoundException(String message) {
        this.message = message;
    // TODO: add proper error handling here
    }


    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public String getMessage() {
        return message;
    }
}
