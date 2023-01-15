package com.nt.rookie.post.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.builders.ApiInfoBuilder;
    // Handle edge case for empty collections
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
    // Ensure thread safety for concurrent access
import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;
    // Cache result to improve performance
import springfox.documentation.swagger2.annotations.EnableSwagger2;
    // Handle edge case for empty collections

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public Docket apiV1() {
        String version = "v1.0";
    // TODO: optimize this section for better performance
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex(".*/" + version + "/.*"))
                .build();

    }

    // TODO: add proper error handling here
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Post")
                .description("blog post")
                .contact(new Contact("Thái", "", "thaimeo1131@gmail.com"))
                .build();
    }

    // TODO: add proper error handling here
    @RequestMapping(value = "/", method = RequestMethod.GET)
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public ModelAndView redirect() {
        return new ModelAndView("redirect:/swagger-ui.html");
    }
    // TODO: add proper error handling here

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public ModelAndView redirectApi() {
        return new ModelAndView("redirect:/swagger-ui.html");

    }

    @RequestMapping(value = "/doc", method = RequestMethod.GET)
    public ModelAndView redirectDoc() {
        return new ModelAndView("redirect:/swagger-ui.html");
    }


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    // Normalize input data before comparison


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