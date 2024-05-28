package com.ciscos.project.berserker;

import com.ciscos.project.Character;
import com.ciscos.project.utils.Damage;
import java.util.Random;

public class Berserker extends Character {

    private int strength;
    private int currentStrength;
    private int critRate;
    public int rageCritRate;
    private int inRage;

    public Berserker(String name, double hp, int speed, int strength, int critRate) {
        super(name, hp, speed);
        this.strength = strength;
        this.critRate = critRate;
        this.currentStrength = strength;
        this.rageCritRate = critRate;
        this.inRage = 0;
    }

    public void checkRage() {
        if (this.getHp() < this.getMaxHp() * 0.5 && inRage < 1) {
            inRage = 1;

        }

        if (this.getHp() < this.getMaxHp() * 0.25) {
            inRage = 2;
        }
    }

    @Override
    public void restore() {
        super.restore();
        inRage = 0;
        this.currentStrength = this.strength;
        this.rageCritRate = this.critRate;
        
    }
    
       @Override
    public void increaseLevel() {
        super.increaseLevel();
        
        double newStrength = this.strength * 1.1;
        this.strength = (int) Math.ceil(newStrength);

        inRage = 0;
        this.currentStrength = this.strength;
        this.rageCritRate = this.critRate;
    }


    @Override
    public Damage attack() {
        checkRage();
        double multiplier = 0;
        double damage = 0;
        String name = this.getName();
        Random aleatorio = new Random();
        int sorteado = aleatorio.nextInt(100);

        if (this.equipment.getNecklace() != null && this.equipment.getNecklace().getAtributeMultiplier().equals("strength")) {
            multiplier += this.equipment.getNecklace().getMultiplier();
            System.out.println("O Item: " + this.equipment.getNecklace().getName() + " está buffando o atributo " + this.equipment.getNecklace().getAtributeMultiplier());
        }

        if (this.equipment.getRing() != null && this.equipment.getRing().getAtributeMultiplier().equals("strength")) {
            multiplier += this.equipment.getRing().getMultiplier();
            System.out.println("O Item: " + this.equipment.getRing().getName() + " está buffando o atributo " + this.equipment.getRing().getAtributeMultiplier());
        }

        switch (this.inRage) {
            case 0:
                break;
            case 1:
                this.currentStrength = (int) Math.ceil(this.strength * 1.2);
                this.rageCritRate = 50;
                break;
            case 2:
                this.currentStrength = (int) Math.ceil(this.strength * 1.4);
                this.rageCritRate = 70;
                break;
            default:
                throw new AssertionError();
        }
        if (this.equipment.getWeapon() != null) {
            String weapon = " com seu " + this.equipment.getWeapon().getType() + " '" + this.equipment.getWeapon().getName() + "'";
            multiplier += this.equipment.getWeapon().getMultiplier() * this.currentStrength;

            damage = this.equipment.getWeapon().getDamage() * (1 + multiplier);
            if (sorteado <= rageCritRate) {
                System.out.println("Golpe critico");
                damage = damage * 1.5;
            }
            System.out.printf("%s bateu %s causando %.2f de dano.\n",name ,weapon ,damage);
            return new Damage(damage, "physical");
        } else {
            System.out.printf("%s bateu sem armas causando %.2f de dano.\n",name ,damage);
            return new Damage(damage, "physical");
        }

    }
}
