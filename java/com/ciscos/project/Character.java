package com.ciscos.project;

public class Character extends Entity {

    public Character(String name, double hp, int speed) {
        super(name, hp, speed);
    }

    public void restore() {
        super.setHp(super.getMaxHp());
    }
}
