package com.nazar.entity;

import lombok.Getter;

@Getter
public enum LifeStyle {
    VeryLowActivity(1.2),
    LowActivity(1.1375),
    NormalActivity(1.55),
    HighActivity(1.725),
    VeryHighActivity(1.9);

    LifeStyle(double amr){
        this.amr = amr;
    }
    private double amr;
}
