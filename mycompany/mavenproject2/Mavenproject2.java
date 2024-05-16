package com.mycompany.mavenproject2;

import com.mycompany.mavenproject2.Mage.Spell;
import com.mycompany.mavenproject2.Mage.Mage;
import com.mycompany.mavenproject2.Equipment.Weapon;
import com.mycompany.mavenproject2.Equipment.Armor;
import com.mycompany.mavenproject2.Equipment.Pants;
import com.mycompany.mavenproject2.Equipment.Item;
import com.mycompany.mavenproject2.Equipment.Necklace;
import com.mycompany.mavenproject2.Equipment.Ring;


public class Mavenproject2 {

    public static void main(String[] args) {
        Mage mage = new Mage(100, 10, 5, "Carioquinha gente fina", 100);
        Mage mage2 = new Mage(200, 50, 10, "Vitor", 100);
        mage.setXp(500);
        mage.checkXp();
        Weapon cajadaoDosCria = new Weapon("Pauzão", "Cajado", 0, 0.02);
        Spell bolaDFogo = new Spell(1,10, 15, "As bola dos deuses", 0.02, 10);
        Necklace colar = new Necklace("colar de perolas", "Intelligence", 0.05);
        Ring anel = new Ring("anel do poder", "Intelligence", 0.1);
        Armor armor = new Armor("armadura do jiraya", 10, 0.05);
        Pants pants = new Pants("calça do jiraya", 10, 0.5);
        mage2.equipment.equip(new Item(armor, true, false, 1));
        mage2.equipment.equip(new Item(pants, true, false, 1));
        mage.equipment.equip(new Item(cajadaoDosCria, true, false, 1));
        mage.equipment.equip(new Item(colar, true,true,1));
        mage.equipment.equip(new Item(anel, true,true,1));
        mage.learnSpell(bolaDFogo);
        mage.Combat(mage, mage2);
    }
}
