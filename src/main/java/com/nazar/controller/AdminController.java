package com.nazar.controller;

import com.nazar.entity.User;
import com.nazar.repos.UserRepo;
import com.nazar.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping
    public String panel(){
        return "admin";
    }
    @GetMapping("/allusers")
    public String main(Map<String, Object> model) {
        Iterable<User> users = adminService.getAllUsers();
        model.put("users", users);
        return "allusers";
    }
    @GetMapping("/foods")
    public String foods(){
        return "foods";
    }

}
