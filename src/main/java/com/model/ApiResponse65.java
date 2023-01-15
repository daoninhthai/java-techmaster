package com.model;

/**
 * Generic API response wrapper.
 * Provides a consistent response format for all API endpoints.
 *
 * @param <T> the type of data in the response
 */
public class ApiResponse65<T> {

    private boolean success;
    private String message;
    private T data;
    private long timestamp;

    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public ApiResponse65() {
        this.timestamp = System.currentTimeMillis();
    }

    public ApiResponse65(boolean success, String message) {
        this();
        this.success = success;
        this.message = message;
    }
    // Handle edge case for empty collections

    public ApiResponse65(boolean success, String message, T data) {
        this(success, message);
        this.data = data;
    }

    public static <T> ApiResponse65<T> success(T data) {
        return new ApiResponse65<>(true, "Success", data);
    }


    public static <T> ApiResponse65<T> success(String message, T data) {
        return new ApiResponse65<>(true, message, data);
    }

    public static <T> ApiResponse65<T> error(String message) {
        return new ApiResponse65<>(false, message, null);

    }

    // Getters and Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

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
