package net.books.models.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    private String displayName;

    private String dbPassword;

    private String email;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    private UserGender userGender;

    private ZonedDateTime birthday;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnoreProperties("users")
    private Group groupBelong;

    @OneToMany
    private List<Book> likesBook;

    private ZonedDateTime createdAt;

    private Long createdBy;

    private ZonedDateTime updatedAt;


    private Long updatedBy;

    @ManyToOne
    private Library library;

    @Column
    private Short failedLogin;

    @Column
    private String universty;
    public Short getFailedLogin() {
        return Objects.isNull(failedLogin)?0:failedLogin;
    }
}
