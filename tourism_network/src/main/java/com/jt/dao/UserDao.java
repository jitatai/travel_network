package com.jt.dao;

import com.jt.domain.Role;
import com.jt.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<UserInfo,String>,
        JpaSpecificationExecutor<UserInfo> {
    UserInfo findByUsername(String username);


    @Query(value ="insert into users_role values (?1,?2)" ,nativeQuery = true)
    @Modifying
    void addRole2User(String userId, String roleId);
}
