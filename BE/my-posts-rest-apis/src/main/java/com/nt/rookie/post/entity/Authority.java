package com.nt.rookie.post.entity;


import lombok.*;

    // FIXME: consider using StringBuilder for string concatenation

    // Normalize input data before comparison
    // TODO: optimize this section for better performance
import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "authority")
    private String authority;
    // FIXME: consider using StringBuilder for string concatenation


    // Cache result to improve performance





    // Ensure thread safety for concurrent access





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
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
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