package com.nazar.service;

import com.nazar.dto.FoodCartDTO;
import com.nazar.dto.UserDTO;
import com.nazar.entity.Food;
import com.nazar.entity.Role;
import com.nazar.entity.User;
import com.nazar.repos.UserRepository;
import com.nazar.view.Regexes;
import com.nazar.view.TextConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    private FoodService foodService;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private MealService mealService;

    public void saveNewUser(User user) {
        countDailyCalories(user);
        try {
            userRepository.save(user);
        } catch (Exception e) {
            log.info("Not Unique Login - " + user.getUsername());
            throw new RuntimeException(e);

        }
        log.info("Successfully registered " + user);
    }

    private boolean checkRegex(String exp, String regexp) {
        return exp.matches(regexp);
    }

    public boolean checkUser(UserDTO user, Map<String, Object> model) {
        boolean check = true;
        if (!checkRegex(user.getUsername(), Regexes.NICKPAS)) {
            model.put("loginerr", TextConst.WRONGLOGIN);
            log.info(TextConst.WRONGLOGIN);
            check = false;
        }
        if (!checkRegex(user.getPassword(), Regexes.NICKPAS)) {
            model.put("passerr", TextConst.WRONGPASS);
            log.info(TextConst.WRONGPASS);
            check = false;
        }
        return check;
    }

    public User getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(userDetails.getUsername());
    }

    public void countDailyCalories(User user) {
        user.setDailyCalories((int)(
                (user.getSex().getBaseCalories()
                        + user.getSex().getWeightC() * user.getWeight()
                        + user.getSex().getHeightC() * user.getHeight()
                        + user.getSex().getAgeC() * user.getAge())
                        * user.getLifeStyle().getAmr()
        ));
    }

    public int getTodayCaloriesConsumedCurrentUser() {
        return mealService.getCurrentUserMeals().stream()
                .filter(m->m.getAddTime().isEqual(LocalDate.now()))
                .mapToInt(m->mealService.getMealCalories(m))
                .sum();
    }
    public boolean isLimitExceeded(){
        return getTodayCaloriesConsumedCurrentUser() > getCurrentUser().getDailyCalories();
    }
    public boolean isUserAdmin(){
        return getCurrentUser().getRoles().contains(Role.ADMIN);
    }
    public List<Food> getAvailableFoods(FoodCartDTO dto) {
        List<Food> foodList = new ArrayList<>();
        foodList.addAll(foodService.getAllByUserId(getCurrentUser().getId()));
        foodList.addAll(foodService.getAllPublicFoodList());
        return  foodList.stream()
                .filter(a -> !dto.getMap().keySet().contains(a))
                .sorted(Comparator.comparing(Food::getFoodName))
                .collect(Collectors.toList());
    }

}
