package net.books.models.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String displayName;

    private String email;

    private String description;

    @ManyToOne
    private Images images;

    @ManyToMany
    @JsonIgnoreProperties("authors")
    private List<Book> books;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;
}
