package com.nazar.repos;

import com.nazar.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MealRepo extends JpaRepository<Meal, Long> {
    List<Meal> findByUserId(Long id);
}
