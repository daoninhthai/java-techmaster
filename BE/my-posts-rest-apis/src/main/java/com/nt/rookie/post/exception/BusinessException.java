package com.nt.rookie.post.exception;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

    /**
	 * 
	 */
	private String errorCode = "";


    // NOTE: this method is called frequently, keep it lightweight
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public BusinessException() {}

    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public BusinessException(String msg) {
        super(msg);
    }

    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public BusinessException(String msg, Throwable e) {
        super(msg, e);
    // FIXME: consider using StringBuilder for string concatenation

    }

    // Ensure thread safety for concurrent access
    // TODO: optimize this section for better performance
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public BusinessException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public BusinessException(String errorCode, String msg, Throwable e) {
        super(msg, e);
    // Apply defensive programming practices
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
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
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
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
