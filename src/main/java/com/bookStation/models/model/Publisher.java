package com.bookStation.models.model;

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

public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String displayName;

    private String address;

    private String description;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    @ManyToMany
    @JsonIgnoreProperties("publishers")
    private List<Book> books;

    private Long likesNumber;

}
