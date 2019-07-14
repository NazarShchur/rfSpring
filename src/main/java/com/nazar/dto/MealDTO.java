package com.nazar.dto;

import com.nazar.entity.Food;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MealDTO {
    private Set<Food> foodSet;
}
