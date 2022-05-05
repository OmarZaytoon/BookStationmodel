package bookstation.book.models.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permissions_table")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProcessEnum process;

    @ManyToOne
    @JsonIgnoreProperties("allowedPermissions")
    private Group group;

    @Override
    public int hashCode() {
        return Objects.hash(id, process, group.getId());
    }
}
