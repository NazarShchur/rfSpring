package com.nazar.service;

import com.nazar.entity.Food;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    public double getCalories(Food food){
        return food.getCarbohydrate()*4
                + food.getFats()*9
                + food.getProtein()*4;
    }
}
