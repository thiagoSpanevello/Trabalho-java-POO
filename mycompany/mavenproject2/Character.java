package com.mycompany.mavenproject2;

import com.mycompany.mavenproject2.Equipment.Item;
import com.mycompany.mavenproject2.Equipment.Equipment;

public class Character {

    private final String name;
    private int level;
    private double xp;
    private int maxHp;
    private int hp;
    private int skillPoints;
    private final Item[] inventory = new Item[30];
    public final Equipment equipment = new Equipment();

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.level = 0;
        this.xp = 0;
        this.skillPoints = 0;
    }
    
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void increaseLevel() {
        this.level++;
        setSkillPoints(this.skillPoints++);
        double newHp = this.maxHp * 1.05;
        this.maxHp = (int) newHp;
        this.hp = this.maxHp;
    }

    public void restore() {
        this.hp = this.maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void putOnInventory(Item item) {
        for (int i = 0; i < 30; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                return;
            }
        }
        System.out.println("Inventário cheio");
    }

    public Item[] getInventory() {
        return inventory;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
    
    public void Combat(Character char1, Character char2){
    
    }
    
    public double attack(){
        return 0;
    }
    
}
