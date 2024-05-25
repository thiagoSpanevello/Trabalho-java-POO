package com.ciscos.project;

import com.ciscos.project.equipment.Equipment;
import com.ciscos.project.items.Item;
import com.ciscos.project.utils.Damage;
import com.ciscos.project.utils.Utils;
import com.ciscos.project.utils.hasName;

public class Entity implements hasName {
    private String name;
    private int level;
    private double maxHp;
    private double hp;
    private Item[] inventory = new Item[30];
    public final Equipment equipment = new Equipment();
    private int speed;
    private int coins; 
    private double xp;
    private double maxXp;
    
    public Entity(String name, double hp, int speed) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.level = 1;
        this.speed = speed;
        this.coins = 0;
        this.xp = 0;
        this.maxXp = 100;
    }
    
    public Entity(String name, double hp, int speed, int coins) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.level = 1;
        this.speed = speed;
        this.coins = coins;
    }
    
    public Entity(int invSize, int coins) {
        this.inventory = new Item[invSize];
        this.coins = coins;
    }

    @Override
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(double maxHp) {
        this.maxHp = maxHp;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
    
    public void putOnInventory(Item item) {
        item = new Item(item.data, item.price, item.sellable, item.getCurrentStack(), item.maxStack);
        if (item.maxStack > 1) {
            for (int i = 0; i < this.inventory.length; i++) {
                if (inventory[i] != null && inventory[i].data.getName() == item.data.getName()) {
                    if (inventory[i].getCurrentStack() == item.maxStack) {
                        continue;
                    }
                    try {
                        inventory[i].incrementStack(item.getCurrentStack());
                        return;
                    } catch (Exception e) {
                        int n = Integer.parseInt(e.getMessage());
                        putOnInventory(new Item(item.data, item.price, item.sellable, n, item.maxStack));
                        return;
                    }
                }
            }
        }
        for (int i = 0; i < this.inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                return;
            }
        }
        System.out.println("Inventário cheio");
        System.out.println("Selecione o item a ser descartado: (0 descartar o atual)");
        int selected = Utils.select(inventory, this.inventory.length);
        if (selected < 0) {
            return;
        }
        inventory[selected] = item;
    }

    public void equip(Item item) {
        try {
            Item res = this.equipment.equip(item);
            if (res != null) {
                putOnInventory(res);
            }

            System.out.println("Equipado.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void equip(int selected) {
        try {
            Item res = this.equipment.equip(inventory[selected]);
            inventory[selected] = null;
            if (res != null) {
                putOnInventory(res);
            }
            System.out.println("Equipado.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void equip() {
        System.out.println("Selecione o item a ser equipado: ");
        int selected = Utils.select(inventory, this.inventory.length);

        try {
            Item res = this.equipment.equip(inventory[selected]);
            if (res != null) {
                putOnInventory(res);
            }
            System.out.println("Equipado.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Item[] getInventory() {
        return inventory;
    }
    
    public void removeFromInventory(int i) {
        if(i < 0 || i >= this.inventory.length) return;
        inventory[i] = null;
    }

    public Damage attack() {
        return new Damage(0.0, "physical");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public double getMaxXp() {
        return maxXp;
    }

    public void setMaxXp(double maxXp) {
        this.maxXp = maxXp;
    }
    
    public void increaseLevel() {
        this.level = this.level + 1;
        double newHp = this.getMaxHp() * 1.05;
        this.setMaxHp(newHp);
        this.setHp(newHp);
        
        double newSpeed = this.speed * 1.1;
        this.speed = (int) Math.ceil(newSpeed);
    }
    
    public boolean checkXp() {
        if (xp >= maxXp) {
            increaseLevel();
            setXp(xp - maxXp);
            return true;
        }
        return false;
    }
}
