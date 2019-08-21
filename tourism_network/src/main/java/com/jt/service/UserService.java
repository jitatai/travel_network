package com.jt.service;

import com.jt.dao.UserDao;
import com.jt.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }
}
