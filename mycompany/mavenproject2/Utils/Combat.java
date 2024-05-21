package com.mycompany.mavenproject2.Utils;

import com.mycompany.mavenproject2.Entity;
import java.util.Random;

public class Combat {

    public static void attack(Entity a, Entity b) {
        Damage damage = a.attack();
                        
        double resist = 0;

        if (a.equipment.getArmor() != null) {
            if (damage.type == "magicResist") {
                resist += b.equipment.getArmor().magicResist;
            } else {
                resist += b.equipment.getArmor().defense;
            }
        }
        if (a.equipment.getPants() != null) {
            if (damage.type == "magicResist") {
                resist += b.equipment.getPants().magicResist;
            } else {
                resist += b.equipment.getPants().defense;
            }
        }
        double resistedDamage = damage.damage * resist;
        double damageDealt = damage.damage - resistedDamage;
        System.out.printf("%s bloqueou %.2f de dano\n", b.getName(), resistedDamage);
        System.out.printf("%s recebeu %.2f de dano\n", b.getName(), damageDealt);
        double currentHp = b.getHp() - damageDealt;
        if(currentHp < 0) b.setHp(0);
        else b.setHp(currentHp);
        System.out.println(b.getName() + " está com " + b.getHp() + " pontos de vida;");
    }
    
    public static void fight(Entity a, Entity b){
        while(a.getHp() > 0 || b.getHp() > 0) {
            if(a.getSpeed() > b.getSpeed()){
                Combat.attack(a, b);
            }
            else if(a.getSpeed() < b.getSpeed()){
                Combat.attack(b, a);
            } else {
                Random random = new Random();
                int op = random.nextInt(2 - 1 + 1) + 1;
                if(op == 1){
                    Combat.attack(a, b);
                } else {
                    Combat.attack(b, a);
                }
            }
            System.out.println("------------------------------");
        }
    } 
}
