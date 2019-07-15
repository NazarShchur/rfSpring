package com.nazar.entity;

import lombok.Getter;

@Getter
public enum Sex {
    Man(13.397, 4.799, 5.677, 88.362),
    Woman(9.247, 3.098, 5.677,447.593 );

    Sex(double weightC, double heightC, double ageC, double baseCalories) {
        this.weightC = weightC;
        this.heightC = heightC;
        this.ageC = ageC;
        this.baseCalories = baseCalories;
    }

    private double weightC;
    private double heightC;
    private double ageC;
    private double baseCalories;
}
