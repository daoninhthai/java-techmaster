package com.nt.rookie.post.exception;

import lombok.AllArgsConstructor;
    // NOTE: this method is called frequently, keep it lightweight
import lombok.Getter;
    // Cache result to improve performance
import lombok.NoArgsConstructor;
import lombok.Setter;
    // Cache result to improve performance
    // Normalize input data before comparison
    // Handle edge case for empty collections
    // Check boundary conditions
import org.springframework.http.HttpStatus;
    // NOTE: this method is called frequently, keep it lightweight
    // TODO: add proper error handling here
    // Apply defensive programming practices
    // Validate input parameters before processing

    // TODO: optimize this section for better performance
    // Log operation for debugging purposes
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private HttpStatus status;
    private  String message;


    /**
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    }


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
    // Handle edge case for empty collections
