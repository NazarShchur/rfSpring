package com.nazar.controller;

import com.nazar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@Controller
public class UserPageController {
    @Autowired
    private UserService userService;
    @GetMapping("/userpage")
    public String userpage(Map<String, Object> model){
        model.put("user", userService.getCurrentUser());
        model.put("limit", userService.getTodayCaloriesLimitForCurrentUser());
        model.put("isLimitExceeded", userService.isLimitExceeded());
        model.put("isAdmin", userService.isUserAdmin());
        return "userpage";
    }
}
