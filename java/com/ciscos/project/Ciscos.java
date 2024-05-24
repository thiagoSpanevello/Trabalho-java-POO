package com.ciscos.project;

import com.ciscos.project.archer.Archer;
import com.ciscos.project.archer.Arrow;
import com.ciscos.project.mage.Spell;
import com.ciscos.project.mage.Mage;
import com.ciscos.project.equipment.Weapon;
import com.ciscos.project.items.Item;
import com.ciscos.project.frames.Principal;
import com.ciscos.project.utils.Combat;
import com.ciscos.project.utils.Context;
import com.ciscos.project.utils.Utils;

public class Ciscos {

    public static void main(String[] args) {
        Principal principal = new Principal();
        Context.setMainWindow(principal);
        principal.setVisible(true);
        Mage mage = new Mage("Carioquinha gente fina", 100, 100, 10, 5);
        Mage mage2 = new Mage("Vitor", 100, 200, 50, 10);
        Weapon arco = new Weapon("élfico", "arco", 2, 0.02);
        Spell bolaDFogo = new Spell(10, 15, "As bola dos deuses", 0.02);
        
        Archer a = new Archer("Caua", 60, 15, 5);
        a.equip(new Item(arco, 10, true, 1));
        
        Item flecha = new Item(new Arrow(7.0, 0.02), 2, true, 1, 64);
        
        a.putOnInventory(flecha);
        a.putOnInventory(flecha);
        Utils.print(a.getInventory());
        a.attack();
        Utils.print(a.getInventory());
        a.attack();
        Utils.print(a.getInventory());
    }
}
