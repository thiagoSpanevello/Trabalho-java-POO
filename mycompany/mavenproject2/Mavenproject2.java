package com.mycompany.mavenproject2;

import com.mycompany.mavenproject2.Mage.Spell;
import com.mycompany.mavenproject2.Mage.Mage;
import com.mycompany.mavenproject2.Equipment.Weapon;
import com.mycompany.mavenproject2.Equipment.Item;
import com.mycompany.mavenproject2.Utils.Combat;
import com.mycompany.mavenproject2.Utils.Utils;

public class Mavenproject2 {

    public static void main(String[] args) {
        Mage mage = new Mage("Carioquinha gente fina", 100, 100, 10, 5, 10);
        Mage mage2 = new Mage("Vitor", 100, 200, 50, 10, 12);
        Weapon cajadaoDosCria = new Weapon("Pauzão", "cajado", 0, 0.02);
        Spell bolaDFogo = new Spell(10, 15, "As bola dos deuses", 0.02);
    }
}
