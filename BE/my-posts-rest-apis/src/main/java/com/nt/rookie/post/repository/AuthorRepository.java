package com.nt.rookie.post.repository;

import com.nt.rookie.post.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    public Author findByUsername(String username);
}
