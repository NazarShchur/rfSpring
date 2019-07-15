package com.nazar.dto;

import com.nazar.entity.Food;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CountFoodDTO {
    Food food;
    Integer count;
}
