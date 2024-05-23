package com.ciscos.project.utils;

import com.ciscos.project.Entity;
import com.ciscos.project.items.Item;
import java.util.Random;

public class Combat {

    public static void attack(Entity a, Entity b) {
        System.out.println("------------------------------");
        System.out.println(a.getName());
        Damage damage = a.attack();

        double resist = 0;

        if (a.equipment.getArmor() != null) {
            if (damage.type == "magic") {
                resist += b.equipment.getArmor().magicResist;
            } else {
                resist += b.equipment.getArmor().defense;
            }
        }
        if (a.equipment.getPants() != null) {
            if (damage.type == "magic") {
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
        if (currentHp < 0) {
            b.setHp(0);
        } else {
            b.setHp(currentHp);
        }
        System.err.printf("%s está com %.2f pontos de vida;\n", b.getName(), b.getHp());
    }

    public static void fight(Entity a, Entity b) {
        while (a.getHp() > 0 || b.getHp() > 0) {
            if (a.getSpeed() > b.getSpeed()) {
                Combat.attack(a, b);
                if (b.getHp() == 0) {
                    break;
                }
                Combat.attack(b, a);
            } else if (a.getSpeed() < b.getSpeed()) {
                Combat.attack(b, a);
                if (a.getHp() == 0) {
                    break;
                }
                Combat.attack(a, b);
            } else {
                Random random = new Random();
                int op = random.nextInt(2 - 1 + 1) + 1;
                if (op == 1) {
                    Combat.attack(a, b);
                    if (b.getHp() == 0) {
                        break;
                    }
                    Combat.attack(b, a);
                } else {
                    Combat.attack(b, a);
                    if (a.getHp() == 0) {
                        break;
                    }
                    Combat.attack(a, b);
                }
            }
        }
        System.out.println("------------------------------");
        
        int[] xpByLevel = {33, 20, 10};

        Entity winner = a;
        Entity loser = b;
        
        if (a.getHp() == 0) {
           winner = b;
           loser = a;
        }

        
         System.out.printf("%s derrotou %s\n", winner.getName(), loser.getName());
            int xpPortion = loser.getLevel() / winner.getLevel();
            int multiplier = xpByLevel[0];
            if (winner.getLevel() > xpByLevel.length) {
                multiplier = xpByLevel[xpByLevel.length - 1];
            } else {
                multiplier = xpByLevel[winner.getLevel() - 1];
            }

            winner.setXp(xpPortion * multiplier);
            winner.checkXp();

            winner.setCoins(winner.getCoins() + loser.getCoins());
            loser.setCoins(0);
            loser.setXp(0);

            Item[] inv = loser.getInventory();

            for (int i = 0; i < 30; i++) {
                if (inv[i] == null) {
                    continue;
                }
                winner.putOnInventory(inv[i]);
            }
    }
}
