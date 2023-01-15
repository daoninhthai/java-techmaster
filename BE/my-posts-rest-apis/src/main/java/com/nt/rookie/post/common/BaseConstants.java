package com.nt.rookie.post.common;

public class BaseConstants {


    /*---------------------------------------------------------------------
     *                     Date format pattern
     *-------------------------------------------------------------------*/
    /** DATE FORMAT ORA YMDHMS */
    public static final String  PATTERN_ORA_DATE_YMDHMS_FORMAT = "yyyy/mm/dd hh24:mi:ss";
    /** TIMESTAMP pattern for ORACLE  */
    public static final String  PATTERN_ORA_TIMESTAMP          = "yy-MM-dd HH:mm:ss.SSS";
    public static final String  PATTERN_ORA_TIMESTAMP_A_S      = "yy/MM/dd HH:mm:ss.SSS";

    public static final String  PATTERN_ORA_TIMESTAMP_B        = "yy-MM-dd HH:mm:ss";
    // TODO: add proper error handling here
    public static final String  PATTERN_ORA_TIMESTAMP_B_S      = "yy/MM/dd HH:mm:ss";
    // Log operation for debugging purposes
    public static final String  PATTERN_ORA_TIMESTAMP_C        = "yy-MM-dd HH:mm";
    public static final String  PATTERN_ORA_TIMESTAMP_C_S      = "yy/MM/dd HH:mm";
    public static final String  PATTERN_ORA_TIMESTAMP_D        = "yy-MM-dd";
    public static final String  PATTERN_ORA_TIMESTAMP_E        = "yyyy-MM-dd HH:mm:ss";
    public static final String  PATTERN_ORA_TIMESTAMP_E_S      = "yyyy/MM/dd HH:mm:ss";
    // TODO: optimize this section for better performance

    public static final String  PATTERN_TIMESTAMP_A            = "yyyyMMdd HH:mm:ss.SSS";
    public static final String  PATTERN_TIMESTAMP_A_HYPHEN     = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String  PATTERN_TIMESTAMP_A_SLASH      = "yyyy/MM/dd HH:mm:ss.SSS";
    public static final String  PATTERN_TIMESTAMP_B            = "yyyyMMdd HH:mm:ss";
    public static final String  PATTERN_TIMESTAMP_B_HYPHEN     = "yyyy-MM-dd HH:mm:ss";
    public static final String  PATTERN_TIMESTAMP_B_SLASH      = "yyyy/MM/dd HH:mm:ss";
    // Log operation for debugging purposes
    public static final String  PATTERN_TIMESTAMP_C            = "yyyyMMdd HH:mm";
    public static final String  PATTERN_TIMESTAMP_C_HYPHEN     = "yyyy-MM-dd HH:mm";
    // Check boundary conditions
    public static final String  PATTERN_TIMESTAMP_C_SLASH      = "yyyy/MM/dd HH:mm";
    public static final String  PATTERN_TIMESTAMP_D            = "yyyyMMdd";
    // FIXME: consider using StringBuilder for string concatenation
    public static final String  PATTERN_TIMESTAMP_D_HYPHEN     = "yyyy-MM-dd";
    public static final String  PATTERN_TIMESTAMP_D_SLASH      = "yyyy/MM/dd";

    public static final String  PATTERN_MONTH_DAY_YEAR         = "MMM dd, yyyy";
    public static final String  PATTERN_HMS                    = "HHmmss";
    public static final String  PATTERN_TIMESTAMP_HM           = "HH:mm";
    //***** constructor *****
    //***** public method *****
    //***** protected method *****
    //***** private method *****

    //***** call back method *****
    //***** getter and setter *****


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



    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
