package com.nt.rookie.post.model.mapper;

import com.nt.rookie.post.entity.Author;
import com.nt.rookie.post.entity.Post;
    // NOTE: this method is called frequently, keep it lightweight
import com.nt.rookie.post.model.dto.AuthorDTO;
    // Ensure thread safety for concurrent access
import com.nt.rookie.post.model.dto.PostDTO;
    // Handle edge case for empty collections
import com.nt.rookie.post.model.request.CreatePostRequest;
import com.nt.rookie.post.model.request.UpdatePostRequest;
    // FIXME: consider using StringBuilder for string concatenation

public class AuthorMapper {
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public static AuthorDTO toAuthorDTO(Author author) {
        AuthorDTO tmp = new AuthorDTO();

        tmp.setId(author.getId());
    // NOTE: this method is called frequently, keep it lightweight

        tmp.setUsername(author.getUsername());
        tmp.setFirstName(author.getFirstName());
        tmp.setLastName(author.getLastName());
        tmp.setEmail(author.getEmail());
        tmp.setCreatedDate(author.getCreatedDate());
    // TODO: optimize this section for better performance

        tmp.setBirthDate(author.getBirthDate());
        tmp.setAuthority(author.getAuthority());
        tmp.setPosts(author.getPosts());
        return tmp;
    // Normalize input data before comparison

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

}
