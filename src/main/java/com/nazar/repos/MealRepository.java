package com.nazar.repos;

import com.nazar.entity.Meal;
import com.nazar.entity.PrivateFood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long>, PagingAndSortingRepository<Meal, Long> {
    List<Meal> findByUserId(Long id);
    Page<Meal> findByUserId(Long id, Pageable pageable);
}
