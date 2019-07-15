package com.nazar.controller;

import com.nazar.dto.CountFoodDTO;
import com.nazar.dto.FoodDTO;
import com.nazar.entity.Food;
import com.nazar.entity.Meal;
import com.nazar.repos.FoodRepo;
import com.nazar.repos.MealRepo;
import com.nazar.service.FoodService;
import com.nazar.service.MealService;
import com.nazar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/userpage/addmeal")
public class MealController {
    private final FoodRepo foodRepo;
    private final MealRepo mealRepo;
    @Autowired
    private MealService mealService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private UserService userService;
    private Meal meal;

    @Autowired
    public MealController(FoodRepo foodRepo, MealRepo mealRepo) {
        this.foodRepo = foodRepo;
        this.mealRepo = mealRepo;
    }

    @GetMapping
    public String showMeal(Map<String, Object> model) {
        meal = new Meal();
        meal.setFoodCount(new HashMap<>());
        model.put("foods", foodService.getAvalaibleFoods(meal));
        return "addmeal";
    }

    @PostMapping
    public String addFood(FoodDTO foodDTO, Map<String, Object> model) {
        if (foodDTO.getFoodName() == null) {
            model.put("meal", meal);
            model.put("foods", foodService.getAvalaibleFoods(meal));
            model.put("error", "Choose Food!");
            return "addmeal";
        }
        Food food = foodRepo.findByFoodName(foodDTO.getFoodName());
        mealService.addFoodToMeal(meal, CountFoodDTO.builder()
                .food(food)
                .count(foodDTO.getCount())
                .build());
        model.put("foods", foodService.getAvalaibleFoods(meal));
        model.put("meal", meal);
        return "addmeal";
    }

    @PostMapping("/saveMeal")
    public String saveMeal(Map<String, Object> model, String description) {
        meal.setDescription(description);
        mealService.SaveMeal(meal);
        model.put("mealadded", "Meal Added");
        return "addmeal";
    }

    @GetMapping("/allmeals")
    public String allMeals(Map<String, Object> model) {
        Iterable<Meal> meals = mealRepo.findByUserId(userService.getCurrentUser().getId());
        model.put("meals", meals);
        return "allmeals";
    }
}
