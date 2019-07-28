package com.nazar.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@EqualsAndHashCode(callSuper = true)
public class PrivateFood extends Food {
    @ManyToOne
    private User user;
    @Builder(builderMethodName = "privateBuilder")
    public PrivateFood(Long id, String foodName, double protein, double fats, double carbohydrate, User user) {
        this.id = id;
        this.foodName = foodName;
        this.protein = protein;
        this.fats = fats;
        this.carbohydrate = carbohydrate;
        this.user = user;
    }
}
