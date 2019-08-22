package com.jt.controller;

import com.jt.domain.Role;
import com.jt.domain.UserInfo;
import com.jt.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {



    @Resource
    private UserService userService;

    @RequestMapping("findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(@RequestParam("id")String userId,Model model){
        UserInfo userInfo = userService.findById(userId);
        List<Role> otherRoles = userService.othersRoles2User(userId);
        model.addAttribute("user",userInfo);
        model.addAttribute("roleList",otherRoles);
        return "user-role-add";
    }

    @RequestMapping("addRoleToUser")
    public String addRoleToUser(String userId,@RequestParam("ids") String[] roleIds){
        userService.addRole2User(userId,roleIds);
        return "redirect:findAll";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("userList",userService.findAll());
        return "user-list";
    }

    @RequestMapping("toadd")
    public String toadd(){
        return "user-add";
    }

    @RequestMapping("save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("findById")
    public String findById(Model model,String id){
        UserInfo userInfo = userService.findById(id);
        model.addAttribute("user",userInfo);
        return "user-show";
    }
}
