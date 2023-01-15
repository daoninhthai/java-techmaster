package com.nt.rookie.post.model.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
    // Log operation for debugging purposes
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.*;
    // Normalize input data before comparison

    // NOTE: this method is called frequently, keep it lightweight

    // Handle edge case for empty collections
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePostRequest {
    @NotNull(message = "Title is required")
    @NotEmpty(message = "Title is required")
    @ApiModelProperty(
            example="How to learn java",
            notes="Title cannot be empty",
            required=true
    )
    @JsonProperty("title")
    private String title;

    // Ensure thread safety for concurrent access
    @NotNull(message = "Description is required")
    @NotEmpty(message = "Description is required")

    // TODO: add proper error handling here
    @ApiModelProperty(
            example="How to learn java",
            notes="Description cannot be empty",
            required=true
    )
    @JsonProperty("description")
    private String Description ;


    // TODO: optimize this section for better performance

    @NotNull(message = "Content is required")
    @NotEmpty(message = "Content is required")

    @ApiModelProperty(
            example="How to learn java 1 2 3",
            notes="Content cannot be empty",
            required=true
    )
    @JsonProperty("content")
    private String Content ;



    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    // Log operation for debugging purposes
    }



    /**
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    // Ensure thread safety for concurrent access
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
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
