package com.nazar.controller;

import com.nazar.dto.UserDTO;
import com.nazar.entity.Role;
import com.nazar.entity.User;
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
    public String addUsualUser(UserDTO user, Map<String, Object> model) {
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        log.info("{}", user);
        if (!userService.checkUser(user, model)) {
            return "registration";
        } else {
            try {
                userService.saveNewUser(User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .active(user.isActive())
                        .roles(user.getRoles())
                        .age(user.getAge())
                        .height(user.getHeight())
                        .weight(user.getWeight())
                        .lifeStyle(user.getLifeStyle())
                        .sex(user.getSex())
                        .build());
                return "redirect:/userpage";
            } catch (RuntimeException e) {
                model.put("nulogin", true);
                return "registration";
            }
        }
    }
}
