package com.nazar.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FoodDTO {
    private String foodName;
    private int count;
}
