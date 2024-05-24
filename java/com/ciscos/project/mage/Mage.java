package com.ciscos.project.mage;

import com.ciscos.project.Character;
import com.ciscos.project.utils.Damage;
import java.util.Scanner;

public class Mage extends Character {

    private int mana;
    private int maxMana;
    private Spell[] spells = new Spell[3];
    private int intelligence;

    public Mage(String name, double hp, int speed, int maxMana, int intelligence) {
        super(name, hp, speed);
        this.mana = maxMana;
        this.maxMana = maxMana;
        this.intelligence = intelligence;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void learnSpell(Spell spell) {

        for (int i = 0; i < 3; i++) {
            if (spells[i] == null) {
                spells[i] = spell;
                System.out.println(this.getName() + " aprendeu " + spell.getName());
                return;
            }
        }

        System.out.println("Máximo de feitiços aprendidos, substitua algum (0 para cancelar):");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ": " + spells[i].getName());
        }
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        if (option < 1 || option > 3) {
            return;
        }
        spells[option - 1] = spell;
        System.out.println(this.getName() + " aprendeu " + spell.getName());
        scanner.close();

    }

    public Spell[] getSpells() {
        return spells;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void increaseLevel() {
        super.increaseLevel();
        double newIntelligence = this.intelligence * 1.1;
        this.intelligence = (int) Math.ceil(newIntelligence);
        double newMana = this.maxMana * 1.05;
        this.maxMana = (int) newMana;
        this.mana = this.maxMana;

        this.restore();
    }

    @Override
    public void restore() {
        super.restore();
        this.mana = this.maxMana;
    }

    public Damage attack() {
        Scanner scan = new Scanner(System.in);
        int op;
        System.out.println("Escolha a magia que deseja usar: ");
        do {
            for (int i = 0; i < 3; i++) {
                if (this.getSpells()[i] != null) {
                    System.out.println(i + 1 + " Magia: " + this.getSpells()[i].getName() + " Dano: " + this.getSpells()[i].getDamage());
                }
            }
            op = scan.nextInt();
        } while (op < 1 || op > 3 || this.getSpells()[op - 1] == null);

        int spell = op - 1;

        double multiplier = 0;
        String weapon = "";
        if (this.equipment.getWeapon() != null) {
            multiplier += this.equipment.getWeapon().getMultiplier();
            weapon = " com seu " + this.equipment.getWeapon().getType() + " '" + this.equipment.getWeapon().getName() + "'";
        }
        if (this.equipment.getNecklace() != null && this.equipment.getNecklace().getAtributeMultiplier().equals("intelligence")) {
            multiplier += this.equipment.getNecklace().getMultiplier();
            System.out.println("O Item: " + this.equipment.getNecklace().getName() + " está buffando o atributo " + this.equipment.getNecklace().getAtributeMultiplier());
        }

        if (this.equipment.getRing() != null && this.equipment.getRing().getAtributeMultiplier().equals("intelligence")) {
            multiplier += this.equipment.getRing().getMultiplier();
            System.out.println("O Item: " + this.equipment.getRing().getName() + " está buffando o atributo " + this.equipment.getRing().getAtributeMultiplier());
        }

        multiplier += spells[spell].getMultiplier() * intelligence;

        String name = this.getName();
        
        if (this.getMana() - spells[spell].getMana() >= 0) {

            setMana(this.getMana() - spells[spell].getMana());
            System.out.println("Mago " + name + " está conjurando...");

            String spellName = spells[spell].getName();
            double damage = spells[spell].getDamage() * (1 + multiplier);

            System.out.println(name + " usou " + spellName + weapon + " causando " + damage + " de dano.");

            return new Damage(damage, "magic");
        }
        
        else if(this.equipment.getWeapon() != null){
            System.out.println(name + " bateu "  + weapon + " causando " + this.equipment.getWeapon().getDamage() + " de dano.");
            return new Damage(this.equipment.getWeapon().getDamage(), "physical");
        }
        
        System.out.println(name + " quer bater com o seu tico...");
        return new Damage(0, "magic");
    }
}
