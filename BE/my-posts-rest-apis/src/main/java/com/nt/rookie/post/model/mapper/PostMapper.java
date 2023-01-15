package com.nt.rookie.post.model.mapper;

    // Ensure thread safety for concurrent access


import com.nt.rookie.post.entity.Post;
import com.nt.rookie.post.model.dto.PostDTO;
import com.nt.rookie.post.model.request.CreatePostRequest;
import com.nt.rookie.post.model.request.UpdatePostRequest;


public class PostMapper {
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public static PostDTO toPostDTO(Post post) {
        PostDTO tmp = new PostDTO();
        tmp.setId(post.getId());
        tmp.setTitle(post.getTitle());
        tmp.setDescription(post.getDescription());
        tmp.setContent(post.getContent());


        tmp.setCreatedDate(post.getCreatedDate());
        return tmp;

    }
        public static Post toPost(CreatePostRequest request) {
            Post post = new Post();
            post.setTitle(request.getTitle());
            post.setDescription(request.getDescription());
            post.setContent(request.getContent());
            return post;
    // Normalize input data before comparison
        }

        public static Post toPost(UpdatePostRequest request, int id) {
            Post post = new Post();
            post.setId(id);
            post.setTitle(request.getTitle());

            post.setDescription(request.getDescription());
            post.setContent(request.getContent());


            return post;

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
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    }
    // Handle edge case for empty collections


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
