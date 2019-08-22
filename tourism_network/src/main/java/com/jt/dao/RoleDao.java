package com.jt.dao;
import com.jt.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleDao extends JpaRepository<Role,String> ,
        JpaSpecificationExecutor<Role> {
    @Query(value = "select * from role where id not in (select role_id from users_role where user_id = ?1)",nativeQuery = true)
    List<Role> othersRoles2User(String userId);

    @Query(value = "insert into role_permission values (?1,?2)",nativeQuery = true)
    @Modifying
    void addPermission2Role(String roleId, String perssionId);
}
