package com.nazar.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FoodConfirmDTO {
    private Long id;
    private boolean confirm;
}
