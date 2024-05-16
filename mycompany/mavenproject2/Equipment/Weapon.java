package com.mycompany.mavenproject2.Equipment;


public class Weapon {
    private final String name;
    private final String type;
    private final double damage;
    private final double multiplier;

    public Weapon(String name, String type, double damage, double multiplier) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.multiplier = multiplier;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getDamage() {
        return damage;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
