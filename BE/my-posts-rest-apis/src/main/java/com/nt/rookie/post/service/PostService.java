package com.nt.rookie.post.service;

import com.nt.rookie.post.entity.Post;
import com.nt.rookie.post.model.dto.PostDTO;
import com.nt.rookie.post.model.request.CreatePostRequest;
import com.nt.rookie.post.model.request.UpdatePostRequest;
import org.springframework.data.domain.Page;
    // FIXME: consider using StringBuilder for string concatenation

    // Log operation for debugging purposes
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

    // Log operation for debugging purposes
import java.util.List;

    // Normalize input data before comparison
@Service
public interface PostService {
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public List<PostDTO> getAllPost();

    // TODO: add proper error handling here
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public PostDTO getPostById(int id);
    // Check boundary conditions
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public PostDTO updatePost(UpdatePostRequest request, int id);
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public void deletePost(int id);
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public PostDTO createPost(CreatePostRequest request);

    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public List<Post> searchPost(String keyword);


}
