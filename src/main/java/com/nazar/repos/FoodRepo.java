package com.nazar.repos;


import com.nazar.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Long> {
    Food findByFoodName(String foodName);
}
