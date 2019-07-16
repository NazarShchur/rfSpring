package com.nazar.service;

import com.nazar.entity.User;
import com.nazar.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final UserRepo userRepo;

    @Autowired
    public AdminService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
}
