package com.nazar.repos;


import com.nazar.entity.Food;
import com.nazar.entity.PrivateFood;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByFoodName(String foodName);
    void deleteById(Long id);
}
