package com.nazar.entity;

import lombok.*;

import javax.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long userId;
    @Column
    private String description;
    @Column
    double allCalories;
    @ElementCollection
    @CollectionTable(name = "FoodCount")
    private Map<Food, Integer> foodCount;
}
