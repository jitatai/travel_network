package com.jt.service;

import com.jt.dao.RoleDao;
import com.jt.dao.UserDao;
import com.jt.domain.Role;
import com.jt.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Resource
    private PasswordEncoder passwordEncoder;
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    public void save(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    public UserInfo findById(String id) {
        return userDao.getOne(id);
    }

    public List<Role> othersRoles2User(String userId) {
        return roleDao.othersRoles2User(userId);
    }

    public void addRole2User(String userId, String[] roleIds) {
        for (String roleId : roleIds){
            userDao.addRole2User(userId,roleId);
        }
    }
}
