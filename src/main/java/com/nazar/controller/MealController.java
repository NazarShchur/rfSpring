package com.nazar.controller;

import com.nazar.dto.CountFoodDTO;
import com.nazar.dto.FoodDTO;
import com.nazar.dto.FoodCartDTO;
import com.nazar.entity.Food;
import com.nazar.entity.Meal;
import com.nazar.service.FoodService;
import com.nazar.service.MealService;
import com.nazar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.*;


@Slf4j
@Controller
@RequestMapping("/userpage/addmeal")
public class MealController {
    @Autowired
    private MealService mealService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String showMeal(Map<String, Object> model, HttpServletRequest request) {
        FoodCartDTO currentMap = mealService.getFoodCart(request);
        model.put("foods", userService.getAvailableFoods(currentMap));
        model.put("isFoodInMap", currentMap.getMap().size() > 0);
        return "addmeal";
    }

    @PostMapping
    public String addFood(FoodDTO foodDTO, Map<String, Object> model, HttpServletRequest request) {
        FoodCartDTO currentMap = mealService.getFoodCart(request);
        if (foodDTO.getFoodName() == null) {
            model.put("isFoodInMap", currentMap.getMap().size() > 0);
            model.put("error", "Choose Food!");
            return "redirect/userpage/addmeal";
        }
        Food food = foodService.findFoodByName(foodDTO.getFoodName());
        mealService.addFoodToCart(currentMap, CountFoodDTO.builder()
                .food(food)
                .count(foodDTO.getCount())
                .build());
        mealService.updateCart(request, currentMap);
        model.put("currentMap", currentMap);
        return "redirect:/userpage/addmeal";
    }

    @PostMapping("/saveMeal")
    public String saveMeal(String description, HttpServletRequest request){
        mealService.saveMeal(Meal.builder()
                .description(description)
                .addTime(LocalDate.now())
                .foodCount(mealService.getFoodCart(request).getMap())
                .user(userService.getCurrentUser())
                .build());
        mealService.updateCart(request, new FoodCartDTO());
        return "redirect:/userpage/addmeal";
    }

    @PostMapping("/delete")
    public String deleteFoodFromMeal(Map<String, Object> model, String foodName, HttpServletRequest request) {
        FoodCartDTO currentMap = mealService.getFoodCart(request);
        mealService.deleteFoodFromCart(currentMap, foodService.findFoodByName(foodName));
        mealService.updateCart(request, currentMap);
        model.put("currentMap", currentMap);
        return "redirect:/userpage/addmeal";
    }
}
