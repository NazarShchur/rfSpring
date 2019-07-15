package com.nazar.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FoodAddDTO {
    private String foodName;
    private double protein;
    private double fats;
    private double carbohydrate;
}
