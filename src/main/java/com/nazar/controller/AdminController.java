package com.nazar.controller;

import com.nazar.dto.FoodConfirmDTO;
import com.nazar.entity.User;
import com.nazar.service.AdminService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String panel(Map<String, Object> model){
        model.put("usersFood", adminService.findUsersFood());
        return "admin";
    }


    @PostMapping("/publicFood")
    public String confirm(Long foodID){
        adminService.updateFoodToPublic(foodID);
        return "redirect:/admin";
    }

}
