package com.nazar.entity;

import lombok.*;

import javax.persistence.*;

import java.awt.print.Pageable;
import java.time.LocalDate;
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
    @ManyToOne
    private User user;
    @Column
    private String description;
    @Transient
    private int allCalories;
    @ElementCollection
    @CollectionTable(name = "FoodCount")
    private Map<Food, Integer> foodCount;
    @Column
    private LocalDate addTime;
}
