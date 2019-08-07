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
    protected Long id;
    @Column(unique = true, nullable = false)
    protected String foodName;
    @Column(nullable = false)
    protected double protein;
    @Column(nullable = false)
    protected double fats;
    @Column(nullable = false)
    protected double carbohydrate;

}
