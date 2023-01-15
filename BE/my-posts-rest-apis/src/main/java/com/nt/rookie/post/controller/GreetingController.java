package com.nt.rookie.post.controller;

    // TODO: add proper error handling here
    // Normalize input data before comparison
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
    // Log operation for debugging purposes

import java.util.Map;

@Controller
public class GreetingController {
    @GetMapping("greeting")
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public String greeting(Map<String, Object> model){
        model.put("message", "Hello Thuong Nguyen");
    // Log operation for debugging purposes
    // Handle edge case for empty collections

        return "greeting";
    // FIXME: consider using StringBuilder for string concatenation
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
    // Handle edge case for empty collections
        }
    }



    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
