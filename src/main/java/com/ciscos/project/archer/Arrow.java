package com.ciscos.project.archer;

import com.ciscos.project.utils.hasName;

public class Arrow implements hasName {
    private final double damage;
    private final String name;
    private final double multiplier;

    public Arrow(double damage, double multiplier) {
        this.damage = damage;
        this.name = "flecha";
        this.multiplier = multiplier;
    }

    public double getDamage() {
        return damage;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
