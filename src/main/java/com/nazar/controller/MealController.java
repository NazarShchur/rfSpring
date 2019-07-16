package com.nazar.controller;

import com.nazar.dto.CountFoodDTO;
import com.nazar.dto.FoodDTO;
import com.nazar.entity.Food;
import com.nazar.entity.Meal;
import com.nazar.service.FoodService;
import com.nazar.service.MealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


@Slf4j
@Controller
@RequestMapping("/userpage/addmeal")
public class MealController {
    @Autowired
    private MealService mealService;
    @Autowired
    private FoodService foodService;
    //TODO change to DTO
    private Meal meal;
    @GetMapping
    public String showMeal(Map<String, Object> model) {
        meal = new Meal();
        meal.setFoodCount(new HashMap<>());
        model.put("foods", mealService.getAvailableFoods(meal));
        return "addmeal";
    }

    @PostMapping
    public String addFood(FoodDTO foodDTO, Map<String, Object> model) {
        if (foodDTO.getFoodName() == null) {
            model.put("meal", meal);
            model.put("foods", mealService.getAvailableFoods(meal));
            model.put("error", "Choose Food!");
            return "addmeal";
        }
        Food food = foodService.findFoodByName(foodDTO.getFoodName());
        mealService.addFoodToMeal(meal, CountFoodDTO.builder()
                .food(food)
                .count(foodDTO.getCount())
                .build());
        model.put("foods", mealService.getAvailableFoods(meal));
        model.put("meal", meal);
        return "addmeal";
    }

    @PostMapping("/saveMeal")
    public String saveMeal(Map<String, Object> model, String description) {
        meal.setDescription(description);
        mealService.saveMeal(meal);
        model.put("mealadded", "Meal Added");
        return "addmeal";
    }

    @GetMapping("/allmeals")
    public String allMeals(Map<String, Object> model) {
        Iterable<Meal> meals = mealService.getCurrentUserMeals();
        model.put("meals", meals);
        return "allmeals";
    }

    @PostMapping("/delete")
    public String deleteFoodFromMeal(Map<String, Object> model, String foodName){
        mealService.deleteFoodFromMeal(meal, foodService.findFoodByName(foodName));
        model.put("foods", mealService.getAvailableFoods(meal));
        model.put("meal", meal);
        return "addmeal";
    }
}
