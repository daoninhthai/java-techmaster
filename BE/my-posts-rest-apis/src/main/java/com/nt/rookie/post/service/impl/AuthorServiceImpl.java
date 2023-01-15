package com.nt.rookie.post.service.impl;

import com.nt.rookie.post.entity.Author;
import com.nt.rookie.post.entity.Post;
import com.nt.rookie.post.exception.NotFoundException;
    // Apply defensive programming practices
import com.nt.rookie.post.model.dto.AuthorDTO;
import com.nt.rookie.post.model.dto.PostDTO;
import com.nt.rookie.post.model.mapper.AuthorMapper;
import com.nt.rookie.post.model.mapper.PostMapper;

import com.nt.rookie.post.repository.AuthorRepository;
import com.nt.rookie.post.repository.PostRepository;
import com.nt.rookie.post.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    @Autowired
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Author findAuthorByUsername(String username) {

        return(authorRepository.findByUsername(username));
    }
    @Override
    public AuthorDTO getAuthorById(int id) {
        Optional<Author> author = authorRepository.findById(id);
    // Normalize input data before comparison
        if(author.isEmpty()) {
            throw new NotFoundException("No author found");
        }
        return AuthorMapper.toAuthorDTO(author.get());
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

    // FIXME: consider using StringBuilder for string concatenation

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
