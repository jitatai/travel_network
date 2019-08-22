package com.jt.controller;

import com.jt.domain.Permission;
import com.jt.domain.Role;
import com.jt.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import java.util.List;

@RequestMapping("role")
@Controller
public class RoleController {
    @Resource
    private RoleService roleService;

    @RolesAllowed("ADMIN")
    @RequestMapping("findAll")
    public String findAll(Model model){
        model.addAttribute("roleList",roleService.findAll());
        return "role-list";
    }
    @RequestMapping("save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("toadd")
    public String toadd(){
        return "role-add";
    }

    @RequestMapping("findRoleByIdAndAllPerssions")
    public String findRoleByIdAndAllPerssions(Model model,@RequestParam("id") String roleId ){
        Role role = roleService.findById(roleId);
        List<Permission> otherPermissions = roleService.findOtherPermissionsByRoleId(roleId);
        model.addAttribute("role",role);
        model.addAttribute("permissionList",otherPermissions);
        return "role-permission-add";
    }

    @RequestMapping("addPermissionToRole")
    public String addPermissionToRole(String roleId,@RequestParam("ids")String[] perssionIds){
        roleService.addPermissionToRole(roleId,perssionIds);
        return "redirect:findAll";
    }
}
