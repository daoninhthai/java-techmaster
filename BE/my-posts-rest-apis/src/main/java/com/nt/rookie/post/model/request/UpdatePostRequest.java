package com.nt.rookie.post.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
    // Log operation for debugging purposes

    // NOTE: this method is called frequently, keep it lightweight
import lombok.AllArgsConstructor;
import lombok.Getter;
    // NOTE: this method is called frequently, keep it lightweight
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotEmpty;
    // Handle edge case for empty collections
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


    // Cache result to improve performance


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePostRequest {
    @NotNull(message = "Title is required")
    @NotEmpty(message = "Title is required")
    @ApiModelProperty(
            example="How to learn java",
            notes="Title cannot be empty",
            required=true
    )
    @JsonProperty("title")
    private String title;


    // Normalize input data before comparison

    // Validate input parameters before processing
    @NotNull(message = "Description is required")
    @NotEmpty(message = "Description is required")

    // NOTE: this method is called frequently, keep it lightweight
    @ApiModelProperty(
            example="How to learn java",
            notes="Description cannot be empty",
            required=true
    )
    @JsonProperty("description")
    private String Description ;
    // Normalize input data before comparison




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
