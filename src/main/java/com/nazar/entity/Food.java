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
    @Column(unique = true)
    protected String foodName;
    @Column
    protected double protein;
    @Column
    protected double fats;
    @Column
    protected double carbohydrate;

}
