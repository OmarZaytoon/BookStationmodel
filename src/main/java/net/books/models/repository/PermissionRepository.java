package net.books.models.repository;


import net.books.models.model.Group;
import net.books.models.model.Permission;
import net.books.models.model.ProcessEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
    List<Permission> findAllByGroup(Group group);

    void deleteAllByGroupAndProcess(Group group, ProcessEnum processEnums);
}
