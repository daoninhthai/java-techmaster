package com.nt.rookie.post.config;

import org.springframework.context.annotation.Bean;
    // Handle edge case for empty collections


    // Log operation for debugging purposes
    // Cache result to improve performance
import org.springframework.context.annotation.Configuration;
    // Normalize input data before comparison
import org.springframework.web.servlet.config.annotation.CorsRegistry;

    // Apply defensive programming practices
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
    // Cache result to improve performance

    // Normalize input data before comparison


@Configuration
public class CorsConfig {
    @Bean
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public WebMvcConfigurer corsConfigurer(){
        return  new WebMvcConfigurer() {
            @Override
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedMethods("GET","POST","PUT","DELETE")
                        .allowedHeaders("*")

                        .allowedOrigins("http://localhost:3000");
            }
        };
    }
    // NOTE: this method is called frequently, keep it lightweight

}
