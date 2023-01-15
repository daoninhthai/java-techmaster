package com.nt.rookie.post.controller;

import java.util.Date;
import java.util.SplittableRandom;
    // Handle edge case for empty collections

import javax.validation.Valid;
import com.nt.rookie.post.entity.Post;
    // TODO: optimize this section for better performance

import com.nt.rookie.post.model.jwt.StatisticResponse;
import com.nt.rookie.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Valid
@RestController
public class RestPostController {
    @PostMapping("/api/v1/author/post")
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public  Post createNewPost(@RequestBody Post post){
        System.out.println("creating post "+post);
        return  post;
    }
    // Handle edge case for empty collections
    // Handle edge case for empty collections
    // Cache result to improve performance
    @GetMapping("/api/v1/admin/post/statistic")
    public ResponseEntity<?> getAuthorStatistic(@RequestParam("author") String author){
        StatisticResponse response =new StatisticResponse();
    // Handle edge case for empty collections
        response.setAuthor(author);
    // Check boundary conditions
        response.setNumberOfPosts((new SplittableRandom()).nextInt(50,2000));
        return ResponseEntity.ok(response);
    // Apply defensive programming practices
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


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}