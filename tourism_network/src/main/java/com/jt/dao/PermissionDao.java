package com.jt.dao;

import com.jt.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PermissionDao extends JpaRepository<Permission,String>,
        JpaSpecificationExecutor<Permission> {
    @Query(value = "select * from permission where id not in (select permission_id from role_permission where role_id = ?1)",nativeQuery = true)
    List<Permission> findOtherPermissionsByRoleId(String roleId);
}
