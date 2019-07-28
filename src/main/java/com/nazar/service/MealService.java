package com.nazar.service;

import com.nazar.dto.CountFoodDTO;
import com.nazar.dto.FoodCartDTO;
import com.nazar.entity.Food;
import com.nazar.entity.Meal;
import com.nazar.repos.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MealService {
    private final MealRepository mealRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void countMealCalories(Meal meal) {
        meal.setAllCalories((int)(meal.getFoodCount().keySet().stream()
                .mapToDouble(a -> foodService.getCalories(a) * meal.getFoodCount().get(a))
                .sum()));
    }
    public int getMealCalories(Meal meal){
        return (int)meal.getFoodCount().keySet().stream()
                .mapToDouble(a->foodService.getCalories(a) * meal.getFoodCount().get(a))
                .sum();
    }

    public void addFoodToCart(FoodCartDTO cart, CountFoodDTO countFoodDTO) {
        cart.getMap().put(countFoodDTO.getFood(), countFoodDTO.getCount());
    }

    public void saveMeal(Meal meal) {
        meal.setUser(userService.getCurrentUser());
        mealRepository.save(meal);
    }

    public Page<Meal> getCurrentUserMeals(Pageable pageable) {
        return mealRepository.findByUserId(userService.getCurrentUser().getId(), pageable);
    }
    public List<Meal> getCurrentUserMeals() {
        return mealRepository.findByUserId(userService.getCurrentUser().getId());
    }
    public FoodCartDTO getFoodCart(HttpServletRequest request){
        return (FoodCartDTO)Optional.ofNullable(request.getSession().getAttribute("currentMap"))
                .orElse(new FoodCartDTO());
    }
    public void deleteFoodFromCart(FoodCartDTO foods, Food food) {
       foods.getMap().remove(food);
    }
    public void updateCart(HttpServletRequest request, FoodCartDTO foods){
        request.getSession().setAttribute("currentMap", foods);
    }

    public void countMealListCalories(Page<Meal> meals){
        for (Meal meal : meals.getContent()){
            countMealCalories(meal);
        }
    }

}
