package com.ciscos.project.items;

import com.ciscos.project.archer.Arrow;
import com.ciscos.project.equipment.Armor;
import com.ciscos.project.equipment.Necklace;
import com.ciscos.project.equipment.Pants;
import com.ciscos.project.equipment.Ring;
import com.ciscos.project.equipment.Weapon;
import java.util.HashMap;

public class List {

    public static final Item[] armors = {
        new Item(new Armor("armadura de couro", 0.01, 0), 10, true, 1),
        new Item(new Armor("armadura de aço", 0.025, 0), 150, true, 1),
        new Item(new Armor("armadura de ferro negro", 0.030, 0.01), 225, true, 1),
        new Item(new Armor("armadura da yggdrasil", 0.03, 0.05), 300, true, 1),
        new Item(new Armor("armadura do eixo celestial", 0.04, 0.05), 1500, true, 1),
        new Item(new Armor("armadura do cerberus", 0.05, 0.04), 1514, true, 1),
        new Item(new Armor("armadura de mithril", 0.065, 0.05), 2100, true, 1),
        new Item(new Armor("armadura do dragão do fim", 0.075, 0.075), 2400, true, 1),
        new Item(new Armor("armadura de jormungandr", 0.09, 0.085), 2700, true, 1),
        new Item(new Armor("armadura do chaos", 0.1, 0.1), 3000, true, 1),
    };

    public static final Item[] pants = {
        new Item(new Pants("calça de couro", 0.01, 0), 10, true, 1),
        new Item(new Pants("calça de aço", 0.025, 0), 150, true, 1),
        new Item(new Pants("calça de ferro negro", 0.030, 0.01), 225, true, 1),
        new Item(new Pants("calça da yggdrasil", 0.03, 0.05), 300, true, 1),
        new Item(new Pants("calça do eixo celestial", 0.04, 0.05), 1500, true, 1),
        new Item(new Pants("calça do cerberus", 0.05, 0.04), 1514, true, 1),
        new Item(new Pants("calça de mithril", 0.065, 0.05), 2100, true, 1),
        new Item(new Pants("calça do dragão do fim", 0.075, 0.075), 2400, true, 1),
        new Item(new Pants("calça de jormungandr", 0.09, 0.085), 2700, true, 1),
        new Item(new Pants("calça do chaos", 0.1, 0.1), 3000, true, 1),
    };

    public static final HashMap<String, Item> getRings() {
        HashMap<String, Item> rings = new HashMap<>();
        final Item berserkerRing = new Item(new Ring("anel da força", "strength", 0.1), 3000, true, 1);
        final Item mageRing = new Item(new Ring("anel da inteligência", "intelligence", 0.1), 3000, true, 1);
        final Item archerRing = new Item(new Ring("anel da destreza", "dexterity", 0.1), 1500, true, 1);
        rings.put("Berserker", berserkerRing);
        rings.put("Mage", mageRing);
        rings.put("Archer", archerRing);

        return rings;
    }

    public static final HashMap<String, Item> getNecklaces() {
        HashMap<String, Item> necklaces = new HashMap<>();
        final Item berserkerNecklace = new Item(new Necklace("colar da força", "strength", 0.1), 3000, true, 1);
        final Item mageNecklace = new Item(new Necklace("colar da inteligência", "intelligence", 0.1), 3000, true, 1);
        final Item archerNecklace = new Item(new Necklace("colar da destreza", "dexterity", 0.1), 1500, true, 1);

        necklaces.put("Berserker", berserkerNecklace);
        necklaces.put("Mage", mageNecklace);
        necklaces.put("Archer", archerNecklace);

        return necklaces;
    }

    public static final Item[] potions = {
        new Item(new Potion("poção de vida", "hp", 0.2), 50, true, 1, 30),
        new Item(new Potion("poção de mana", "mana", 0.4), 10, true, 1, 30)
    };

    public static final HashMap<String, Item[]> getWeapons() {
        HashMap<String, Item[]> weapons = new HashMap<>();
        final Item[] berserkerWeapons = {
            new Item(new Weapon("Machado de pedra", "Machado", 5, 0.02), 5, true, 1),   // 5 lutas de 30
            new Item(new Weapon("Machado de aço", "Machado", 8, 0.025), 300, true, 1),    // 10 lutas de 30
            new Item(new Weapon("Machado élfico", "Machado", 10, 0.027), 450, true, 1),   // 15 lutas de 30
            new Item(new Weapon("Espada de ferro negro", "Espada", 10, 0.030), 600, true, 1), // 20 lutas de 30
            new Item(new Weapon("Espada do eixo celestial", "Espada", 15, 0.04), 3000, true, 1),  // 100 lutas de 30
            new Item(new Weapon("Espada Cerberus", "Espada", 18, 0.05), 3332, true, 1),   // 120 lutas de 30
            new Item(new Weapon("Espada de mithril", "Espada", 20, 0.06), 4200, true, 1),  // 140 lutas de 30
            new Item(new Weapon("Presa de dragão do fim", "Espada", 24, 0.07), 4800, true, 1), // 160 lutas de 30
            new Item(new Weapon("Presa de jormungandr", "Espada", 28, 0.085), 5400, true, 1),  // 180 lutas de 30
            new Item(new Weapon("Machado do Chaos", "Machado", 30, 0.1), 6000, true, 1),  // 200 lutas de 30
        };
        final Item[] mageWeapons = {
            new Item(new Weapon("Cajado de mago iniciante", "Cajado", 3, 0.02), 5, true, 1),    // 5 lutas de 30
            new Item(new Weapon("Cajado de mago intermediario", "Cajado", 4, 0.05), 300, true, 1),   // 10 lutas de 30
            new Item(new Weapon("Cajado élfico", "Cajado", 5, 0.060), 450, true, 1),   // 15 lutas de 30
            new Item(new Weapon("Cajado de mago experiente", "Cajado", 5, 0.10), 600, true, 1),  // 20 lutas de 30
            new Item(new Weapon("Cajado do eixo celestial", "Cajado", 5, 0.13), 3000, true, 1),   // 100 lutas de 30
            new Item(new Weapon("Cajado Cerberus", "Cajado", 9, 0.15), 3332, true, 1),    // 120 lutas de 30
            new Item(new Weapon("Cajado de mago mestre", "Cajado", 7, 0.17), 4200, true, 1),   // 140 lutas de 30
            new Item(new Weapon("Cajado de dragão do fim", "Cajado", 8, 0.19), 4800, true, 1), // 160 lutas de 30
            new Item(new Weapon("Cajado de jormungandr", "Cajado", 9, 0.2), 5400, true, 1),    // 180 lutas de 30
            new Item(new Weapon("Cajado do Chaos", "Cajado", 10, 0.25), 6000, true, 1),}; // 200 lutas de 30
        final Item[] archerWeapons = {
            new Item(new Weapon("Arco simples", "Arco", 3, 5), 10, true, 1), // 5 lutas de 15
            new Item(new Weapon("Arco recurvo", "Arco", 4, 8), 150, true, 1), // 10 lutas de 15
            new Item(new Weapon("Arco de madeira nobre", "Arco", 5, 10), 225, true, 1),   // 15 lutas de 15
            new Item(new Weapon("Arco do caçador", "Arco", 5, 12), 300, true, 1), // 20 lutas de 15
            new Item(new Weapon("Arco do eixo celestial", "Arco", 5, 15), 1500, true, 1),  // 100 lutas de 15
            new Item(new Weapon("Arco Cerberus", "Arco", 9, 15), 1514, true, 1),  // 120 lutas de 15
            new Item(new Weapon("Arco de arqueiro mestre", "Arco", 7, 20), 2100, true, 1),    // 140 lutas de 15
            new Item(new Weapon("Arco de dragão do fim", "Arco", 8, 24), 2400, true, 1),  // 160 lutas de 15
            new Item(new Weapon("Arco de jormungandr", "Arco", 9, 28), 2700, true, 1),    // 180 lutas de 15
            new Item(new Weapon("Arco do Chaos", "Arco", 10, 30), 3000, true, 1), // 200 lutas de 15
        }; 

        weapons.put("Berserker", berserkerWeapons);
        weapons.put("Mage", mageWeapons);
        weapons.put("Archer", archerWeapons);

        return weapons;
    }

    public static Item[] randoms = {
        new Item(new Arrow(1, 0.02), 1, true, 64),};
}
