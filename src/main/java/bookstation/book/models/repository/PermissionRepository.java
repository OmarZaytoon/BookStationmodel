package bookstation.book.models.repository;


import bookstation.book.models.model.Group;
import bookstation.book.models.model.Permission;
import bookstation.book.models.model.ProcessEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
    List<Permission> findAllByGroup(Group group);

    void deleteAllByGroupAndProcess(Group group, ProcessEnum processEnums);
}
