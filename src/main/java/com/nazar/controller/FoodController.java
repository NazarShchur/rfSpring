package com.nazar.controller;

import com.nazar.dto.FoodAddDTO;
import com.nazar.entity.PrivateFood;
import com.nazar.service.FoodService;
import com.nazar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/userpage/addfood")
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private UserService userService;
    @GetMapping
    public String page() {
        return "addfood";
    }
    @PostMapping
    public String addFood(FoodAddDTO food, Map<String, Object> model) {
        foodService.saveNewFood(PrivateFood.privateBuilder()
                .fats(food.getFats())
                .carbohydrate(food.getCarbohydrate())
                .protein(food.getProtein())
                .foodName(food.getFoodName())
                .user(userService.getCurrentUser())
                .build()
                , model);
        return "addfood";
    }
}
