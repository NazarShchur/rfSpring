package com.nazar.service;

import com.nazar.entity.Food;
import com.nazar.entity.Meal;
import com.nazar.repos.FoodRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Slf4j
@Service
public class FoodService {
    private final FoodRepo foodRepo;
    @Autowired
    public FoodService(FoodRepo foodRepo){
        this.foodRepo = foodRepo;
    }
    public double getCalories(Food food){
        return food.getCarbohydrate()*4
                + food.getFats()*9
                + food.getProtein()*4;
    }
    public List<Food> getAvalaibleFoods(Meal meal) {
        return foodRepo.findAll().stream()
                .filter(a -> !meal.getFoodCount().keySet().contains(a))
                .sorted(Comparator.comparing(Food::getFoodName))
                .collect(Collectors.toList());

    }
}
