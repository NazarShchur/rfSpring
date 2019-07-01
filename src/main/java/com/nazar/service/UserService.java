package com.nazar.service;

import com.nazar.entity.User;
import com.nazar.repos.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class UserService {
    private UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public String saveNewUser (User user, Map<String, Object> model){
        user.setActive(true);
        try {
            userRepo.save(user);
        } catch (Exception e){
            log.info("Not Unique Login - " + user.getUsername());
            model.put("message", "Login " + user.getUsername() + " is occupied, try again!");
            return "/registration";
        }
        log.info("Successfully registered " + user);
        model.put("message", "Registered");
        return "/login";

    }
}
