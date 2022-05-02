package com.bookStation.models.repository;


import com.bookStation.models.model.Group;
import com.bookStation.models.model.Permission;
import com.bookStation.models.model.ProcessEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
    List<Permission> findAllByGroup(Group group);

    void deleteAllByGroupAndProcess(Group group, ProcessEnum processEnums);
}
