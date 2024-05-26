package com.ciscos.project.archer;

import com.ciscos.project.Character;
import com.ciscos.project.items.Item;
import com.ciscos.project.utils.Damage;

public class Archer extends Character {

    private int dexterity;

    public Archer(String name, double hp, int speed, int dexterity) {
        super(name, hp, speed);
        this.dexterity = dexterity;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public void restore() {
        super.restore();

        double newDexterity = this.dexterity * 1.1;
        this.dexterity = (int) Math.ceil(newDexterity);
    }

    private int amountArrows() {
        Item[] inv = this.getInventory();
        int amount = 0;

        for (int i = 0; i < inv.length; i++) {
            if (inv[i] == null || !inv[i].data.getName().equals("flecha")) {
                continue;
            }
            amount += inv[i].getCurrentStack();
        }

        return amount;
    }

    @Override
    public Damage attack() {
        int amount = amountArrows();
                
        String name = this.getName();
        if (amount > 0 && this.equipment.getWeapon() != null) {
            Item[] inv = this.getInventory();

            int i = 0;
            while (i < 30) {
                i++;
                if(inv[i] == null){
                    continue;
                }
                
                if (inv[i].data.getName().equals("flecha")) {
                    break;
                }
            }

            Arrow arrow = (Arrow) inv[i].data;
            
            try {
                inv[i].decreaseStack();
            } catch (Exception e) {
                this.removeFromInventory(i);
            }

            double multiplier = 0;
            multiplier += this.equipment.getWeapon().getMultiplier();
            String weapon = " com seu " + this.equipment.getWeapon().getType() + " '" + this.equipment.getWeapon().getName() + "'";

            if (this.equipment.getNecklace() != null && this.equipment.getNecklace().getAtributeMultiplier().equals("dexterity")) {
                multiplier += this.equipment.getNecklace().getMultiplier();
                System.out.println("O Item: " + this.equipment.getNecklace().getName() + " está buffando o atributo " + this.equipment.getNecklace().getAtributeMultiplier());
            }

            if (this.equipment.getRing() != null && this.equipment.getRing().getAtributeMultiplier().equals("dexterity")) {
                multiplier += this.equipment.getRing().getMultiplier();
                System.out.println("O Item: " + this.equipment.getRing().getName() + " está buffando o atributo " + this.equipment.getRing().getAtributeMultiplier());
            }

            multiplier += arrow.getMultiplier() * dexterity;
            double damage = arrow.getDamage() * (1 + multiplier);
            
            System.out.println(name + " atirou uma flecha" + weapon + " causando " + damage + " de dano.");
            
            return new Damage(damage, "physical");
        }
        else if(this.equipment.getWeapon() != null){
            String weapon = " com seu " + this.equipment.getWeapon().getType() + " '" + this.equipment.getWeapon().getName() + "'";
            System.out.println(name + " bateu "  + weapon + " causando " + this.equipment.getWeapon().getDamage() + " de dano.");
            return new Damage(this.equipment.getWeapon().getDamage(), "physical");
        }

        System.out.println(name + " quer bater com o seu tico...");
        return new Damage(0, "physical");
    }
}
