package com.jt.dao;

import com.jt.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<UserInfo,String>,
        JpaSpecificationExecutor<UserInfo> {
}
