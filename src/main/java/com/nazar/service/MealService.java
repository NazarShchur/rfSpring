package com.nazar.service;

import com.nazar.dto.CountFoodDTO;
import com.nazar.entity.Food;
import com.nazar.entity.Meal;
import com.nazar.repos.MealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService {
    private final MealRepo mealRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;

    @Autowired
    public MealService(MealRepo mealRepo) {
        this.mealRepo = mealRepo;
    }

    public void countMealCalories(Meal meal) {
        meal.setAllCalories(meal.getFoodCount().keySet().stream()
                .mapToDouble(a -> foodService.getCalories(a) * meal.getFoodCount().get(a))
                .sum());
    }

    public void addFoodToMeal(Meal meal, CountFoodDTO countFoodDTO) {
        meal.getFoodCount().put(countFoodDTO.getFood(), countFoodDTO.getCount());
    }

    public void saveMeal(Meal meal) {
        meal.setAddTime(LocalDate.now());
        countMealCalories(meal);
        meal.setUserId(userService.getCurrentUser().getId());
        mealRepo.save(meal);
    }

    public Iterable<Meal> getCurrentUserMeals() {
        return mealRepo.findByUserId(userService.getCurrentUser().getId());
    }
    public List<Food> getAvailableFoods(Meal meal) {
        return foodService.getAllFoodList().stream()
                .filter(Food::isConfirmed)
                .filter(a -> !meal.getFoodCount().keySet().contains(a))
                .sorted(Comparator.comparing(Food::getFoodName))
                .collect(Collectors.toList());
    }
    public void deleteFoodFromMeal(Meal meal, Food food) {
        meal.getFoodCount().remove(food);
    }
    public List<Meal> findMealByDateAndUserId(LocalDate date, Long id){
        return mealRepo.findByAddTimeAndUserId(date, id);
    }

    public double countMealListCalories(List<Meal> meals){
        return meals.stream()
                .mapToDouble(Meal::getAllCalories)
                .sum();
    }


}
