package com.jt.controller;

import com.jt.domain.Permission;
import com.jt.service.PermissionService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("permission")
@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("toadd")
    public String toadd(){
        return "permission-add";
    }

    @RequestMapping("findAll")
    public String findAll(Model model){
        model.addAttribute("permissionList",permissionService.findAll());
        return "permission-list";
    }

    @RequestMapping("save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll";
    }
}
