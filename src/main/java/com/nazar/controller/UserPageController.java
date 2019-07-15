package com.nazar.controller;

import com.nazar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.ws.Action;
import java.security.Principal;
import java.util.Map;

@Controller
public class UserPageController {
    @Autowired
    UserService userService;
    @GetMapping("/userpage")
    public String userpage(Map<String, Object> model){
        model.put("user", userService.getCurrentUser());
        return "userpage";
    }
}
