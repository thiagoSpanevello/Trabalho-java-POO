package com.mycompany.mavenproject2.Equipment;

import com.mycompany.mavenproject2.Utils.hasName;

public class Ring implements hasName{

    private final String name;
    private final String atributeMultiplier;
    private final double multiplier;

    public Ring(String name, String atributeMultiplier, double multiplier) {
        this.name = name;
        this.atributeMultiplier = atributeMultiplier;
        this.multiplier = multiplier;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getAtributeMultiplier() {
        return atributeMultiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
