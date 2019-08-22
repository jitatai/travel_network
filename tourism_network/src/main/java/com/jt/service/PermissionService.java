package com.jt.service;

import com.jt.dao.PermissionDao;
import com.jt.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    public List<Permission> findAll(){
        return permissionDao.findAll();
    }

    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
