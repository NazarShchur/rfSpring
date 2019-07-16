package com.nazar.service;

import com.nazar.entity.Food;
import com.nazar.entity.User;
import com.nazar.repos.FoodRepo;
import com.nazar.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final UserRepo userRepo;
    private final FoodRepo foodRepo;
    @Autowired
    public AdminService(UserRepo userRepo, FoodRepo foodRepo){
        this.userRepo = userRepo;
        this.foodRepo = foodRepo;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    public List<Food> getNotConfirmedFoodList(){
        return foodRepo.findByConfirmedFalse();
    }
    public void updateConfirmedFoodByID(Long id, Boolean status){
        foodRepo.foodUpdateConfirmed(status, id);
    }
    public void deleteFoodById(Long id){
        foodRepo.deleteById(id);
    }
}
