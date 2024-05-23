package com.ciscos.project;

import com.ciscos.project.mage.Spell;
import com.ciscos.project.mage.Mage;
import com.ciscos.project.equipment.Weapon;
import com.ciscos.project.items.Item;
import com.ciscos.project.frames.Principal;
import com.ciscos.project.utils.Combat;
import com.ciscos.project.utils.Utils;

public class Ciscos {

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.setVisible(true);
        Mage mage = new Mage("Carioquinha gente fina", 100, 100, 10, 5, 10);
        Mage mage2 = new Mage("Vitor", 100, 200, 50, 10, 12);
        Weapon cajadaoDosCria = new Weapon("Pauzão", "cajado", 0, 0.02);
        Spell bolaDFogo = new Spell(10, 15, "As bola dos deuses", 0.02);
    }
}
