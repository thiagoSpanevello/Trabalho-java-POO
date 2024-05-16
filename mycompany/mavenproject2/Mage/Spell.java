package com.mycompany.mavenproject2.Mage;

public class Spell {

    private final int levelRequired;
    private final int mana;
    private final double damage;
    private final String name;
    private final double multiplier;
    private final double castingTime;

    public Spell(int levelRequired, int mana, double damage, String name, double multiplier, double castingTime) {
        this.levelRequired = levelRequired;
        this.mana = mana;
        this.damage = damage;
        this.name = name;
        this.multiplier = multiplier;
        this.castingTime = castingTime;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public int getMana() {
        return mana;
    }

    public double getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public double getCastingTime() {
        return castingTime;
    }
}
