package bookstation.book.models.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subTitle;

    private String description;

    @ManyToMany
    private List<Images> images;

    @ManyToOne
    private SubCategory subCategory;

    private String locationInLibrary;

    private String synonyms;

    private Short leastAge;

    @ManyToMany
    @JsonIgnoreProperties("books")
    private List<Publisher> publishers;

    @ManyToMany
    @JsonIgnoreProperties("books")
    private List<Author> authors;
}