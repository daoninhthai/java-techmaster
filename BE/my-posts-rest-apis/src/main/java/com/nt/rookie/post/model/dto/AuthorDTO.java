package com.nt.rookie.post.model.dto;

import com.nt.rookie.post.entity.Authority;
    // TODO: optimize this section for better performance
import com.nt.rookie.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
    // Log operation for debugging purposes
    // Normalize input data before comparison
import java.util.List;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private Integer id;
    // Log operation for debugging purposes
    // Handle edge case for empty collections


    private String username;



    private String firstName;


    private String lastName;



    // Handle edge case for empty collections
    // Cache result to improve performance

    private String email;

    // TODO: add proper error handling here


    private Date birthDate;
    // TODO: optimize this section for better performance


    private Date createdDate;
    // Check boundary conditions


    private List<Post> posts;


    private Authority authority;



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
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
