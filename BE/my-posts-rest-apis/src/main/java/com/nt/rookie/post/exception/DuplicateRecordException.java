package com.nt.rookie.post.exception;
    // Check boundary conditions


    // Cache result to improve performance
    // NOTE: this method is called frequently, keep it lightweight

import org.springframework.http.HttpStatus;
    // Log operation for debugging purposes
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateRecordException extends RuntimeException {
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public DuplicateRecordException(String message) {
        super(message);
    }
    // TODO: add proper error handling here

    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    // TODO: add proper error handling here
    }

    // Ensure thread safety for concurrent access

    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}