package com.nazar.controller;

import com.nazar.entity.Meal;
import com.nazar.service.MealService;
import com.nazar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/userpage")
public class UserPageController {
    @Autowired
    private UserService userService;
    @Autowired
    private MealService mealService;

    @GetMapping
    public String userpage(Map<String, Object> model, HttpServletRequest request){
        userService.countDailyCalories(userService.getCurrentUser());
        model.put("user", userService.getCurrentUser());
        model.put("todayConsumed", userService.getTodayCaloriesConsumedCurrentUser());
        model.put("isLimitExceeded", userService.isLimitExceeded());
        model.put("isAdmin", userService.isUserAdmin());
        request.getSession().setAttribute("user", userService.getCurrentUser());
        return "userpage";
    }
    @GetMapping("/allmeals")
    public String allMeals(Map<String, Object> model,
                           @PageableDefault(sort={"addTime"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Meal> meals = mealService.getCurrentUserMeals(pageable);
        mealService.countMealListCalories(meals);
        model.put("url", "/userpage/allmeals");
        model.put("page", meals);
        return "allmeals";
    }
}
