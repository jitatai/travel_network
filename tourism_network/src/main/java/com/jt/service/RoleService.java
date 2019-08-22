package com.jt.service;

import com.jt.dao.PermissionDao;
import com.jt.dao.RoleDao;
import com.jt.domain.Permission;
import com.jt.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;

    public List<Role> findAll(){
        return roleDao.findAll();
    }

    public void save(Role role){
        roleDao.save(role);
    }

    public List<Permission> findOtherPermissionsByRoleId(String roleId) {
        return permissionDao.findOtherPermissionsByRoleId(roleId);
    }

    public Role findById(String roleId) {
        return roleDao.getOne(roleId);
    }

    public void addPermissionToRole(String roleId, String[] perssionIds) {
        for (String perssionId :perssionIds){
            roleDao.addPermission2Role(roleId,perssionId);
        }
    }
}
