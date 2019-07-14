package com.nazar.controller;

import com.nazar.dto.FoodDTO;
import com.nazar.entity.Food;
import com.nazar.entity.Meal;
import com.nazar.entity.User;
import com.nazar.repos.FoodRepo;
import com.nazar.repos.MealRepo;
import com.nazar.service.MealService;
import com.nazar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@Slf4j
@Controller
@RequestMapping("/userpage/addmeal")
public class MealController {
    private final FoodRepo foodRepo;
    private final MealRepo mealRepo;
    @Autowired
    private MealService mealService;
    @Autowired
    private UserService userService;
    private Meal meal;
    @Autowired
    public MealController(FoodRepo foodRepo, MealRepo mealRepo){
        this.foodRepo = foodRepo;
        this.mealRepo = mealRepo;
    }

    @GetMapping
    public String showMeal(Map<String, Object> model){
            meal = new Meal();
            meal.setFood(new ArrayList<>());
            Iterable<Food> foods = foodRepo.findAll();
            model.put("foods", foods);
            return "addmeal";
    }
    @PostMapping
    public String addMeal(FoodDTO foodDTO,Map<String, Object> model){
        Iterable<Food> foods = foodRepo.findAll();
        model.put("foods", foods);
        Food food = foodRepo.findByFoodName(foodDTO.getFoodName());
        mealService.addFoodToMeal(meal, food);
        return "addmeal";
    }
    @PostMapping("/saveMeal")
    public String saveMeal(Map<String, Object> model, String description){
        if(meal.getFood().size() == 0){
            Iterable<Food> foods = foodRepo.findAll();
            model.put("foods", foods);
            model.put("error", "You have not added any food");
            return "addmeal";
        }
        model.put("mealadded", "Meal Added");
        meal.setDescription(description);
        System.out.println(meal.getDescription());
        mealService.SaveMeal(meal);
        return "addmeal";
    }
    @GetMapping("/allmeals")
    public String allMeals(Map<String, Object> model){
        Iterable<Meal> meals = mealRepo.findByUserId(userService.getCurrentUser().getId());
        model.put("meals", meals);
        return "allmeals";
    }
}
