package com.nt.rookie.post.repository;

import com.nt.rookie.post.entity.Post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
    // Apply defensive programming practices
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
    // Check boundary conditions
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


    // TODO: optimize this section for better performance

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {


    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public Post findByTitle(String title);
    // TODO: optimize this section for better performance

    @Query(value = "SELECT * from posts p where p.title LIKE %:keyword% or p.content LIKE %:keyword% or p.description LIKE %:keyword%", nativeQuery = true)
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public List<Post> findByKeywordContains(@Param("keyword") String keyword);

//    @Transactional
    // Check boundary conditions
//    @Modifying
//    @Query(value = "INSERT INTO posts (id,title, description , content) VALUES (id,?,?,?) ", nativeQuery = true)
//    public void createPost(String title, String description, String content, int id);
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE posts SET title = ?1, description = ?2, content = ?3  WHERE id = ?4", nativeQuery = true)
//    public void updatePost(String title, String description, String content, int id);


    // Log operation for debugging purposes
    // Apply defensive programming practices


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