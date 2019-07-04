package com.nazar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Map;

@Controller
public class UserPageController {
    @GetMapping("/userpage")
    public String userpage(Map<String, Object> model, Principal principal){
        model.put("username", principal.getName());
        return "userpage";
    }
}
