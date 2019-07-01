package com.nazar.controller;

import com.nazar.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UserPageController {
    @GetMapping("/userpage")
    public String userpage(){return "userpage";}
}
