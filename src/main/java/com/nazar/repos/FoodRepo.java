package com.nazar.repos;


import com.nazar.entity.Food;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface FoodRepo extends JpaRepository<Food, Long> {
    Food findByFoodName(String foodName);

    List<Food> findByConfirmedFalse();
    @Transactional
    @Modifying
    @Query("update Food f " +
            "set f.confirmed = :status "+
            "where f.id = :id")
    void foodUpdateConfirmed(@Param("status") Boolean status, @Param("id") Long id);
    void deleteById(Long id);
}
