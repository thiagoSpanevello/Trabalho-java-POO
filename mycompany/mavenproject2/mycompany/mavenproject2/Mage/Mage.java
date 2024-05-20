package com.mycompany.mavenproject2.Mage;

import com.mycompany.mavenproject2.Character;
import java.util.Scanner;

public class Mage extends Character{

    private int mana;
    private int maxMana;
    private Spell[] spells = new Spell[3];
    private int intelligence;
    private int focus;

    public Mage(int maxMana, int intelligence, int focus, String name, int hp) {
        super(name, hp);
        this.mana = maxMana;
        this.maxMana = maxMana;
        this.intelligence = intelligence;
        this.focus = focus;
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
        if (spell.getLevelRequired() > this.getLevel()) {
            System.out.println("Você não tem nível necessário para aprender essa magia!");
        } else {
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

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    @Override
    public void increaseLevel() {
        super.increaseLevel();

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

    public double attack(int spell) {
        double multiplier = 0;
        String weapon = "";
        if (this.equipment.getWeapon() != null) {
            multiplier += this.equipment.getWeapon().getMultiplier();
            weapon = " com seu " + this.equipment.getWeapon().getType() + " '" + this.equipment.getWeapon().getName() + "'";
        }
        if (this.equipment.getNecklace() != null && this.equipment.getNecklace().getAtributeMultiplier() == "Intelligence") {
            multiplier += this.equipment.getNecklace().getMultiplier();
            System.out.println("O Item: " + this.equipment.getNecklace().getName() + " está buffando o atributo " + this.equipment.getNecklace().getAtributeMultiplier());
        }

        if (this.equipment.getRing() != null && this.equipment.getRing().getAtributeMultiplier() == "Intelligence") {
            multiplier += this.equipment.getRing().getMultiplier();
            System.out.println("O Item: " + this.equipment.getRing().getName() + " está buffando o atributo " + this.equipment.getRing().getAtributeMultiplier());
        }

        multiplier += spells[spell].getMultiplier() * intelligence;

        double casting = spells[spell].getCastingTime() - focus * spells[spell].getCastingTime() * spells[spell].getMultiplier();

        setMana(this.getMana() - spells[spell].getMana());
        String name = this.getName();
        try {
            Thread.sleep((long) casting);
            System.out.println("Mago " + name + " está conjurando...");
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        String spellName = spells[spell].getName();
        double damage = spells[spell].getDamage() * (1 + multiplier);

        System.out.println(name + " usou " + spellName + weapon + " causando " + damage + " de dano.");

        return damage;
    }

    public void Combat(Mage attacker, Character defender) {
        System.out.println("Escolha a magia que deseja usar: ");
        for (int i = 0; i < 3; i++) {
            if (attacker.getSpells()[i] != null) {
                System.out.println(i+1 + " Magia: " + attacker.getSpells()[i].getName()+" Dano: " +attacker.getSpells()[i].getDamage());
            }
        }
        Scanner scan = new Scanner(System.in);
        int op = scan.nextInt();
        if(op < 1 || op > 3 || attacker.getSpells()[op] == null) {
            System.out.println("Escolha uma posição que tenha uma magia");
            return;
        }
        double damage = attacker.attack(op-1);
        double magicResist = 0;
        if(defender.equipment.getArmor() != null){
            magicResist += defender.equipment.getArmor().getMagicResist();
        }
        if(defender.equipment.getPants() != null){
            magicResist += defender.equipment.getPants().getMagicResist();
        }
        double resistedDamage = damage * magicResist;
        double damageDealt = damage - resistedDamage;
        System.out.printf("%s bloqueou %.2f de dano",defender.getName(), resistedDamage);
        System.out.printf("\n%s recebeu %.2f de dano",defender.getName(), damageDealt);
        double currentHp = (int) defender.getHp() - damageDealt;
        defender.setHp((int)currentHp);
        System.out.println(defender.getName()+" está com "+ defender.getHp()+" pontos de vida;");
    }
}
