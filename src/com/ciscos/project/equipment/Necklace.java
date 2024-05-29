package com.ciscos.project.equipment;

import com.ciscos.project.utils.hasName;

public class Necklace implements hasName{

    private final String name;
    private final String atributeMultiplier;
    private final double multiplier;

    public Necklace(String name, String atributeMultiplier, double multiplier) {
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