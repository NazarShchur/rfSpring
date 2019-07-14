package com.nazar.service;

import com.nazar.dto.FoodDTO;
import com.nazar.dto.MealDTO;
import com.nazar.entity.Food;
import com.nazar.entity.Meal;
import com.nazar.entity.User;
import com.nazar.repos.MealRepo;
import com.nazar.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



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
        meal.setAllCalories(meal.getFood().stream()
                .mapToDouble(a->foodService.getCalories(a))
                .sum());
        System.out.println(meal.getAllCalories());

    }
    public void addFoodToMeal(Meal meal, Food food){
        meal.getFood().add(food);
    }
    public void SaveMeal(Meal meal){
        countMealCalories(meal);
        meal.setUserId(userService.getCurrentUser().getId());
        mealRepo.save(meal);
    }
}
