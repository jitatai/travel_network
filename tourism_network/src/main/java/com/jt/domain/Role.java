package com.jt.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Role {
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator",strategy = "uuid")
    @Column(name = "id")
    private String id;
    private String roleName;
    private String roleDesc;

    @ManyToMany
    @JoinTable(name = "role_permission",joinColumns = @JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "permissionId"))
    private List<Permission> permissions;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private List<UserInfo> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
