package com.mycompany.mavenproject2;

import com.mycompany.mavenproject2.Equipment.Equipment;
import com.mycompany.mavenproject2.Equipment.Item;
import com.mycompany.mavenproject2.Utils.Utils;
import com.mycompany.mavenproject2.Utils.hasName;

public class Entity implements hasName {
    private final String name;
    private int level;
    private double maxHp;
    private double hp;
    private final Item[] inventory = new Item[30];
    public final Equipment equipment = new Equipment();
    private final int speed;
    private int coins; 
    
    public Entity(String name, double hp, int speed) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.level = 1;
        this.speed = speed;
        this.coins = 0;
    }
    
    public Entity(String name, double hp, int speed, int coins) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.level = 1;
        this.speed = speed;
        this.coins = coins;
    }

    @Override
    public String getName() {
        return name;
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
        item = new Item(item.data, item.price, item.sellable, item.stackable, item.getCurrentStack());

        if (item.stackable) {
            for (int i = 0; i < 30; i++) {
                if (inventory[i] != null && inventory[i].data.getName() == item.data.getName()) {
                    if (inventory[i].getCurrentStack() == 64) {
                        continue;
                    }
                    try {
                        inventory[i].incrementStack(item.getCurrentStack());
                        return;
                    } catch (Exception e) {
                        int n = Integer.parseInt(e.getMessage());
                        putOnInventory(new Item(item.data, item.price, item.sellable, true, n));
                        return;
                    }
                }
            }
        }
        for (int i = 0; i < 30; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                return;
            }
        }
        System.out.println("Inventário cheio");
        System.out.println("Selecione o item a ser equipado: (0 descartar o atual)");
        int selected = Utils.select(inventory, 30);
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

    public void equip() {
        System.out.println("Selecione o item a ser equipado: ");
        int selected = Utils.select(inventory, 30);

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
    
    public void Combat(Entity char1, Entity char2) {

    }

    public double attack() {
        return 0;
    }
}
