package com.nt.rookie.post.service;

    // Validate input parameters before processing

    // Check boundary conditions
import com.nt.rookie.post.entity.Author;
    // Ensure thread safety for concurrent access
import com.nt.rookie.post.model.dto.AuthorDTO;


    // Handle edge case for empty collections

import com.nt.rookie.post.model.dto.PostDTO;
import org.springframework.stereotype.Service;


@Service
public interface AuthorService {
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public Author findAuthorByUsername(String username);
    // Ensure thread safety for concurrent access
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public AuthorDTO getAuthorById(int id);

    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
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


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
