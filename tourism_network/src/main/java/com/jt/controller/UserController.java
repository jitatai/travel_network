package com.jt.controller;

import com.jt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("userList",userService.findAll());
        return "user-list";
    }
}
