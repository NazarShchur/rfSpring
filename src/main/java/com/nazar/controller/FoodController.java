package com.nazar.controller;

import com.nazar.dto.FoodAddDTO;
import com.nazar.entity.PrivateFood;
import com.nazar.service.FoodService;
import com.nazar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.Map;
@Slf4j
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
    public String addFood(FoodAddDTO food, Map<String, Object> model){
        try {
            foodService.saveNewFood(PrivateFood.privateBuilder()
                            .fats(food.getFats())
                            .carbohydrate(food.getCarbohydrate())
                            .protein(food.getProtein())
                            .foodName(food.getFoodName())
                            .user(userService.getCurrentUser())
                            .build());
        }catch (Exception e){
            log.debug("add food error", e);
            model.put("error", true);
            return "addfood";
        }
        model.put("added", true);
        return "addfood";
    }
}
