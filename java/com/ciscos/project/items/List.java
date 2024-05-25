package com.ciscos.project.items;

import com.ciscos.project.archer.Arrow;
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
        final Item berserkerNecklace = new Item(new Ring("colar da força", "strength", 0), 0, true, 1);
        final Item mageNecklace = new Item(new Ring("colar da inteligência", "intelligence", 0), 0, true, 1);
        final Item archerNecklace = new Item(new Ring("colar da destreza", "dexterity", 0), 0, true, 1);

        necklaces.put("Berserker", berserkerNecklace);
        necklaces.put("Mage", mageNecklace);
        necklaces.put("Archer", archerNecklace);

        return necklaces;
    }

    public static final Item[] potions = {
        new Item(new Potion("poção de vida", "hp", 0.2), 0, true, 1, 30),
        new Item(new Potion("poção de mana", "mana", 0.2), 0, true, 1, 30)
    };

    public static final HashMap<String, Item[]> getWeapons() {
        HashMap<String, Item[]> weapons = new HashMap<>();
        final Item[] berserkerWeapons = {
            new Item(new Weapon("Machado de pedra", "Machado", 5, 0.01), 0, true, 1),
            new Item(new Weapon("Machado de aço", "Machado", 8, 0.015), 0, true, 1),
            new Item(new Weapon("Machado élfico", "Machado", 10, 0.017), 0, true, 1),
            new Item(new Weapon("Espada de ferro negro", "Espada", 10, 0.020), 0, true, 1),
            new Item(new Weapon("Espada do eixo celestial", "Espada", 15, 0.025), 0, true, 1),
            new Item(new Weapon("Espada Cerberus", "Espada", 18, 0.025), 0, true, 1),
            new Item(new Weapon("Espada de mithril", "Espada", 20, 0.05), 0, true, 1),
            new Item(new Weapon("Presa de dragão do fim", "Espada", 24, 0.06), 0, true, 1),
            new Item(new Weapon("Presa de jormungandr", "Espada", 28, 0.075), 0, true, 1),
            new Item(new Weapon("Machado do Chaos", "Machado", 30, 0.1), 0, true, 1),
        };
        final Item[] mageWeapons = {
            new Item(new Weapon("Cajado de mago iniciante", "Cajado", 5, 0.01), 0, true, 1),
            new Item(new Weapon("Cajado de mago intermediario", "Cajado", 8, 0.015), 0, true, 1),
            new Item(new Weapon("Cajado élfico", "Cajado", 10, 0.017), 0, true, 1),
            new Item(new Weapon("Cajado de mago experiente", "Cajado", 10, 0.020), 0, true, 1),
            new Item(new Weapon("Cajado do eixo celestial", "Cajado", 15, 0.025), 0, true, 1),
            new Item(new Weapon("Cajado Cerberus", "Cajado", 18, 0.025), 0, true, 1),
            new Item(new Weapon("Cajado de mago mestre", "Cajado", 20, 0.05), 0, true, 1),
            new Item(new Weapon("Cajado de dragão do fim", "Cajado", 24, 0.06), 0, true, 1),
            new Item(new Weapon("Cajado de jormungandr", "Cajado", 28, 0.075), 0, true, 1),
            new Item(new Weapon("Cajado do Chaos", "Cajado", 30, 0.1), 0, true, 1),};
        final Item[] archerWeapons = {
            new Item(new Weapon("Arco simples", "Arco", 5, 0.01), 0, true, 1),
            new Item(new Weapon("Arco recurvo", "Arco", 8, 0.015), 0, true, 1),
            new Item(new Weapon("Arco de madeira nobre", "Arco", 10, 0.017), 0, true, 1),
            new Item(new Weapon("Arco do caçador", "Arco", 10, 0.020), 0, true, 1),
            new Item(new Weapon("Arco do eixo celestial", "Arco", 15, 0.025), 0, true, 1),
            new Item(new Weapon("Arco Cerberus", "Arco", 18, 0.025), 0, true, 1),
            new Item(new Weapon("Arco de arqueiro mestre", "Arco", 20, 0.05), 0, true, 1),
            new Item(new Weapon("Arco de dragão do fim", "Arco", 24, 0.06), 0, true, 1),
            new Item(new Weapon("Arco de jormungandr", "Arco", 28, 0.075), 0, true, 1),
            new Item(new Weapon("Arco do Chaos", "Arco", 30, 0.1), 0, true, 1),};

        weapons.put("Berserker", berserkerWeapons);
        weapons.put("Mage", mageWeapons);
        weapons.put("Archer", archerWeapons);

        return weapons;
    }

    public static Item[] randoms = {
        new Item(new Arrow(12, 0.02), 2, true, 64),};
}
