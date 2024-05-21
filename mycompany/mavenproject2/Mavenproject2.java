package com.mycompany.mavenproject2;

import com.mycompany.mavenproject2.Mage.Spell;
import com.mycompany.mavenproject2.Mage.Mage;
import com.mycompany.mavenproject2.Equipment.Weapon;
import com.mycompany.mavenproject2.Equipment.Item;
import com.mycompany.mavenproject2.Utils.Combat;

public class Mavenproject2 {

    public static void main(String[] args) {
        Mage mage = new Mage("Carioquinha gente fina", 100, 100, 10, 5, 10);
        Mage mage2 = new Mage("Vitor", 100, 200, 50, 10, 12);
        mage.setXp(500);
        mage.checkXp();
        mage2.setXp(500);
        mage.checkXp();
        Weapon cajadaoDosCria = new Weapon("Pauzão", "Cajado", 0, 0.02);
        Spell bolaDFogo = new Spell(1,10, 15, "As bola dos deuses", 0.02, 10);

        mage.equip(new Item(cajadaoDosCria, 100, true, false));
        mage.learnSpell(bolaDFogo);

        mage2.equip(new Item(cajadaoDosCria, 100, true, false));
        mage2.learnSpell(bolaDFogo);
        
        Combat.attack(mage, mage2);
    }
}
