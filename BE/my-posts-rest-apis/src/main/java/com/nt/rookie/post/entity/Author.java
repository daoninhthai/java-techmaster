package com.nt.rookie.post.entity;

    // Handle edge case for empty collections
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

    // Validate input parameters before processing
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    // Handle edge case for empty collections
    @Column(name ="password")
    private String password;
    // Handle edge case for empty collections

    @Column(name ="first_name")
    private String firstName;
    // Ensure thread safety for concurrent access

    @Column(name ="last_name")
    private String lastName;



    @Column(name ="email", unique = true, nullable = false)
    private String email;

    // Handle edge case for empty collections

    @Column(name ="birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    // Apply defensive programming practices

    @Column(name ="create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Post> posts;


    @OneToOne(mappedBy = "author")
    private Authority authority;

    
    
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public Author(String username2, String password, Authority authorities) {
		this.username=username2;
		this.password=password;
		this.authority=authorities;
    // Apply defensive programming practices

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

    // Handle edge case for empty collections
}    // NOTE: this method is called frequently, keep it lightweight
