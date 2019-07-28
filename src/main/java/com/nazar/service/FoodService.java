package com.nazar.service;

import com.nazar.dto.FoodCartDTO;
import com.nazar.entity.Food;
import com.nazar.entity.PrivateFood;
import com.nazar.repos.FoodRepository;
import com.nazar.repos.PrivateFoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FoodService {
    private final FoodRepository foodRepository;
    private final PrivateFoodRepository privateFoodRepository;
    @Autowired
    public FoodService(FoodRepository foodRepository, PrivateFoodRepository privateFoodRepository){
        this.foodRepository = foodRepository;
        this.privateFoodRepository = privateFoodRepository;
    }
    public double getCalories(Food food){
        return food.getCarbohydrate()*4
                + food.getFats()*9
                + food.getProtein()*4;
    }
    public void saveNewFood(Food food, Map<String, Object> model){
        try {
            foodRepository.save(food);
        }catch (Exception e){
            model.put("error", "Food is already in list");
            log.info("Food is already in list");
            return;
        }
        model.put("saved", "Your food will be checked and added soon");
    }

    public Food findFoodByName(String name){
        return foodRepository.findByFoodName(name);
    }
    public List<PrivateFood> getAllPublicFoodList(){
        return privateFoodRepository.findAllByUserIsNull();
    }
    public List<PrivateFood> getAllByUserId(Long id){
        return privateFoodRepository.findAllByUser_Id(id);
    }
}
