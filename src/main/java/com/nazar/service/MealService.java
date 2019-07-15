package com.nazar.service;

import com.nazar.dto.CountFoodDTO;
import com.nazar.entity.Food;
import com.nazar.entity.Meal;
import com.nazar.repos.MealRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


@Service
public class MealService {
    private final MealRepo mealRepo;
    @Autowired
    private UserService userService;
    @Autowired
    FoodService foodService;
    @Autowired
    public MealService(MealRepo mealRepo){
        this.mealRepo = mealRepo;
    }
    public void countMealCalories(Meal meal){
        meal.setAllCalories(meal.getFoodCount().keySet().stream()
                .mapToDouble(a->foodService.getCalories(a)*meal.getFoodCount().get(a))
                .sum());
    }
    public void addFoodToMeal(Meal meal, CountFoodDTO countFoodDTO){
           meal.getFoodCount().put(countFoodDTO.getFood(), countFoodDTO.getCount());
    }
    public void SaveMeal(Meal meal){
        countMealCalories(meal);
        meal.setUserId(userService.getCurrentUser().getId());
        mealRepo.save(meal);
    }

}
