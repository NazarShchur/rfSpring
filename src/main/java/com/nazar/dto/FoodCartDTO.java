package com.nazar.dto;

import com.nazar.entity.Food;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FoodCartDTO {
    private Map <Food, Integer> map = new HashMap<>();
    private int calories;
}
