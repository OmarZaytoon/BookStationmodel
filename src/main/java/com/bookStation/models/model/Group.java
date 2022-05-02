package com.bookStation.models.model;


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
@Table(name = "groups_table")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Library libraryBelong;

    @OneToMany(mappedBy = "groupBelong")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnoreProperties({"groupsBelong","dbPassword"})
    private List<User> users;

    @ManyToOne
    private Category category;

    @OneToMany
    @JsonIgnoreProperties("group")
    private List<Permission> allowedPermissions;

    private ZonedDateTime createdAt;

    private Long createdBy;

    private ZonedDateTime updatedAt;

    private Long updatedBy;



    @Override
    public int hashCode() {
        return Objects.hash(id, groupName, createdAt, createdBy, updatedAt, updatedBy);
    }
}
