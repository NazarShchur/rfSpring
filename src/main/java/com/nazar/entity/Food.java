package com.nazar.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@EqualsAndHashCode
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String foodName;
    @Column
    private double protein;
    @Column
    private double fats;
    @Column
    private double carbohydrate;
    @Column
    private boolean confirmed;
}
