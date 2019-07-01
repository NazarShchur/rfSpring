package com.nazar.controller;

import com.nazar.dto.UserDTO;
import com.nazar.entity.Role;
import com.nazar.entity.User;
import com.nazar.repos.UserRepo;
import com.nazar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Slf4j
@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserDTO user, Map<String, Object> model) {
        user.setRoles(Collections.singleton(Role.USER));
        log.info("{}", user);
        return userService.saveNewUser(new User(user.getUsername(), user.getPassword(), user.getRoles()), model);
    }
}
