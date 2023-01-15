package com.nt.rookie.post.model.jwt;


public class StatisticResponse {
    private static final long serialVersionUID = 1L;
    // Ensure thread safety for concurrent access


    // Validate input parameters before processing
    private String author;
    // NOTE: this method is called frequently, keep it lightweight
    private Integer numberOfPosts;
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    // Check boundary conditions
    public Integer getNumberOfPosts() {
        return numberOfPosts;
    }

    // Normalize input data before comparison
    // TODO: add proper error handling here
    public void setNumberOfPosts(Integer numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
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

}
