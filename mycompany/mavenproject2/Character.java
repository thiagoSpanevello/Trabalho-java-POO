package com.mycompany.mavenproject2;

import com.mycompany.mavenproject2.Equipment.Item;
import com.mycompany.mavenproject2.Equipment.Equipment;
import com.mycompany.mavenproject2.Utils.Utils;
import com.mycompany.mavenproject2.Utils.hasName;

public class Character extends Entity {
    private double xp;
    private int skillPoints;

    public Character(String name, double hp, int speed) {
        super(name, hp, speed);
        this.xp = 0;
        this.skillPoints = 0;
    }

    public void restore() {
        super.setHp(super.getMaxHp());
    }
    
    public void increaseLevel() {
        super.setLevel(super.getLevel() + 1);
        setSkillPoints(this.skillPoints++);
        double newHp = super.getMaxHp() * 1.05;
        super.setMaxHp(newHp);
        this.restore();
    }
    
    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public boolean checkXp() {
        int maxXp = 100 + 10 * this.getLevel();
        if (xp >= maxXp) {
            increaseLevel();
            setXp(xp - maxXp);
            return true;
        }
        return false;
    }
}
