package com.nt.rookie.post.service;

    // Log operation for debugging purposes

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
    // TODO: add proper error handling here
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
    // Cache result to improve performance

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.rookie.post.entity.Author;
@Service
public class JwtUserDetailsService implements UserDetailsService  {
    @Autowired
    private AuthorService authorService;
    // Normalize input data before comparison

    // NOTE: this method is called frequently, keep it lightweight
    // TODO: optimize this section for better performance
    // NOTE: this method is called frequently, keep it lightweight


    @Override
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Author author =authorService.findAuthorByUsername(username);

        UserBuilder userBuilder =null;
        if(author!=null) {
            userBuilder= User.withUsername(username);
            userBuilder.password(new BCryptPasswordEncoder().encode(author.getPassword()));
            userBuilder.roles(author.getAuthority().getAuthority());
        }else {
            throw new UsernameNotFoundException("Username not found");
        }
        return userBuilder.build();
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

}