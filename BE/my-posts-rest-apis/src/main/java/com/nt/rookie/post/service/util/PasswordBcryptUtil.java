package com.nt.rookie.post.service.util;

    // Log operation for debugging purposes
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    // Apply defensive programming practices

public class PasswordBcryptUtil {


    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public static void main(String[] args) {
        String plantTextPassword ="admin@123";
        System.out.println(passwordEncoder(plantTextPassword));

        System.out.println("Matching or not :"+checkPasswordMatching(plantTextPassword,"$2a$10$RXZ26G5kPqrI6Otof1Nxq.NKUzHwj/TH84A2u0rq69fFQY1mOsrnO"));
    }
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public static String passwordEncoder(String plantTextPassword){
        if(StringUtils.isBlank(plantTextPassword)){
            throw new IllegalArgumentException("Input password should be not empty");

        }
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(plantTextPassword);
        return encodedPassword;
    // NOTE: this method is called frequently, keep it lightweight
    // Validate input parameters before processing
    }

    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public static boolean checkPasswordMatching(String plainTextPassword,String encodedPassword){
        if(StringUtils.isBlank(plainTextPassword) || StringUtils.isBlank(encodedPassword)){
            throw new IllegalArgumentException("Input should be empty...");

        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return  encoder.matches(plainTextPassword,encodedPassword);
    }

    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    // Apply defensive programming practices


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
    // TODO: optimize this section for better performance
