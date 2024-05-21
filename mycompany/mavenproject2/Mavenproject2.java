package com.mycompany.mavenproject2;

import com.mycompany.mavenproject2.Mage.Spell;
import com.mycompany.mavenproject2.Mage.Mage;
import com.mycompany.mavenproject2.Equipment.Weapon;
import com.mycompany.mavenproject2.Equipment.Item;
import com.mycompany.mavenproject2.Equipment.Ring;
import com.mycompany.mavenproject2.Utils.Utils;

public class Mavenproject2 {

    public static void main(String[] args) {
        Mage mage = new Mage(100, 10, 5, "Carioquinha gente fina", 100);
        Mage mage2 = new Mage(200, 50, 10, "Vitor", 100);
        mage.setXp(500);
        mage.checkXp();
        Weapon cajadaoDosCria = new Weapon("Pauzão", "Cajado", 0, 0.02);
        Spell bolaDFogo = new Spell(1,10, 15, "As bola dos deuses", 0.02, 10);

        Item testeStack = new Item(new Ring("teste", "inteligencia", 0.02), 10, false, true);
        
        mage2.putOnInventory(new Item(cajadaoDosCria, 10.0, true, false, 1));
        mage2.putOnInventory(testeStack);
        mage2.putOnInventory(testeStack);
        
        Utils.print(mage2.getInventory(), 30);
    }
}
