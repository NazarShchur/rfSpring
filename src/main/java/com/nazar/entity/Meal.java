package com.nazar.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Meal{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long userId;
    @Column
    private String description;
    @Column double allCalories;
    @ManyToMany
    @JoinTable(name = "MealsFoods")
    private List<Food> food;
}
