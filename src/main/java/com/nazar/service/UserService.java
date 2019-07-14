package com.nazar.service;

import com.nazar.dto.MealDTO;
import com.nazar.dto.UserDTO;
import com.nazar.entity.Meal;
import com.nazar.entity.User;
import com.nazar.repos.UserRepo;
import com.nazar.view.Regexes;
import com.nazar.view.TextConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Map;
import java.util.Set;


@Slf4j
@Service
public class UserService {


    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public String saveNewUser(User user, Map<String, Object> model) {
        try {
            userRepo.save(user);
        } catch (Exception e) {
            log.info("Not Unique Login - " + user.getUsername());
            model.put("nulogin", TextConst.ISOCCUPIED);
            return "/registration";
        }
        log.info("Successfully registered " + user);
        return "redirect:/userpage";

    }

    private boolean checkRegex(String exp, String regexp) {
        return exp.matches(regexp);
    }

    public boolean checkUser(UserDTO user, Map<String, Object> model) {
        boolean check = true;
        //TODO remove if
        if (!checkRegex(user.getUsername(), Regexes.NICKPAS)) {
            model.put("loginerr", TextConst.WRONGLOGIN);
            log.info(TextConst.WRONGLOGIN);
            check = false;
        }
        if (!checkRegex(user.getPassword(), Regexes.NICKPAS)) {
            model.put("passerr", TextConst.WRONGPASS);
            log.info(TextConst.WRONGPASS);
            check = false;
        }
        return check;
    }

    public User getCurrentUser() {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepo.findByUsername(userDetails.getUsername());
    }


}
