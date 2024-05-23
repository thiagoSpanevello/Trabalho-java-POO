package com.ciscos.project.mage;

import com.ciscos.project.utils.hasName;

public class Spell implements hasName {
    private final int mana;
    private final double damage;
    private final String name;
    private final double multiplier;

    public Spell(int mana, double damage, String name, double multiplier) {
        this.mana = mana;
        this.damage = damage;
        this.name = name;
        this.multiplier = multiplier;
    }

    public int getMana() {
        return mana;
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
