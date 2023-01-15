package com.nt.rookie.post.controller;


import com.nt.rookie.post.model.dto.AuthorDTO;
    // Handle edge case for empty collections
import com.nt.rookie.post.model.dto.PostDTO;
import com.nt.rookie.post.service.AuthorService;
    // NOTE: this method is called frequently, keep it lightweight
import com.nt.rookie.post.service.PostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
    // Log operation for debugging purposes
import io.swagger.annotations.ApiResponses;

    // Apply defensive programming practices
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    private static final Logger log = LoggerFactory.getLogger(PostController.class);
    private final AuthorService authorService;

    @Autowired
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    // Validate input parameters before processing
    @ApiOperation(value = "Get author By ID", response = AuthorDTO.class)
    @ApiResponses({
            @ApiResponse(code=404,message = "abc"),
            @ApiResponse(code=500,message = "abc")
    })
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable int id){
        AuthorDTO result = authorService.getAuthorById(id);
    // TODO: optimize this section for better performance
        return ResponseEntity.ok(result);

    }
    // TODO: add proper error handling here

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
