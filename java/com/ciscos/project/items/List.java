package com.ciscos.project.items;

import com.ciscos.project.equipment.Armor;
import com.ciscos.project.equipment.Pants;
import com.ciscos.project.equipment.Ring;
import com.ciscos.project.equipment.Weapon;
import java.util.HashMap;

public class List {

    public static final Item[] armors = {
        new Item(new Armor("armadura de couro", 0, 0), 0, true, 1),
        new Item(new Armor("armadura de aço", 0, 0), 0, true, 1),
        new Item(new Armor("armadura élfica", 0, 0), 0, true, 1),
        new Item(new Armor("armadura de ferro negro", 0, 0), 0, true, 1),
        new Item(new Armor("armadura dos ramos da yggdrasil", 0, 0), 0, true, 1),
        new Item(new Armor("armadura do eixo celestial", 0, 0), 0, true, 1),
        new Item(new Armor("armadura de couro do cerberus", 0, 0), 0, true, 1),
        new Item(new Armor("armadura de mithril", 0, 0), 0, true, 1),
        new Item(new Armor("armadura das escamas do dragão do fim", 0, 0), 0, true, 1),
        new Item(new Armor("armadura das escamas de jormungandr", 0, 0), 0, true, 1)
    };

    public static final Item[] pants = {
        new Item(new Pants("calça de couro", 0, 0), 0, true, 1),
        new Item(new Pants("calça de aço", 0, 0), 0, true, 1),
        new Item(new Pants("calça élfica", 0, 0), 0, true, 1),
        new Item(new Pants("calça de ferro negro", 0, 0), 0, true, 1),
        new Item(new Pants("calça dos ramos da yggdrasil", 0, 0), 0, true, 1),
        new Item(new Pants("calça do eixo celestial", 0, 0), 0, true, 1),
        new Item(new Pants("calça de couro do cerberus", 0, 0), 0, true, 1),
        new Item(new Pants("calça de mithril", 0, 0), 0, true, 1),
        new Item(new Pants("calça das escamas do dragão do fim", 0, 0), 0, true, 1),
        new Item(new Pants("calça das escamas de jormungandr", 0, 0), 0, true, 1)
    };

    public static final HashMap<String, Item> getRings() {
        HashMap<String, Item> rings = new HashMap<>();
        final Item berserkerRing = new Item(new Ring("anel da força", "strength", 0), 0, true, 1);
        final Item mageRing = new Item(new Ring("anel da inteligência", "intelligence", 0), 0, true, 1);
        final Item archerRing = new Item(new Ring("anel da destreza", "dexterity", 0), 0, true, 1);
        rings.put("Berserker", berserkerRing);
        rings.put("Mage", mageRing);
        rings.put("Archer", archerRing);

        return rings;
    }

    public static final HashMap<String, Item> getNecklaces() {
        HashMap<String, Item> necklaces = new HashMap<>();
        final Item berserkerNecklace = new Item(new Ring("colar  da força", "strength", 0), 0, true, 1);
        final Item mageNecklace = new Item(new Ring("colar da inteligência", "intelligence", 0), 0, true, 1);
        final Item archerNecklace = new Item(new Ring("colar  da inteligência", "dexterity", 0), 0, true, 1);

        necklaces.put("Berserker", berserkerNecklace);
        necklaces.put("Mage", mageNecklace);
        necklaces.put("Archer", archerNecklace);

        return necklaces;
    }

    public static final Item[] potions = {
        new Item(new Potion("poção de vida", "hp", 0), 0, true, 1),
        new Item(new Potion("poção de mana", "mana", 0), 0, true, 1)
    };

    public static final HashMap<String, Item[]> getWeapons() {
        HashMap<String, Item[]> weapons = new HashMap<>();
        final Item[] berserkerWeapons = {
            new Item(new Weapon("poção de vida", "", 0, 0), 0, true, 1),
        };
        final Item[] mageWeapons = {};
        final Item[] archerWeapons = {};

        weapons.put("Berserker", berserkerWeapons);
        weapons.put("Mage", mageWeapons);
        weapons.put("Archer", archerWeapons);

        return weapons;
    }

    public static Item[] randoms = {};
}
