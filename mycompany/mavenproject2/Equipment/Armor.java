package com.mycompany.mavenproject2.Equipment;

import com.mycompany.mavenproject2.Utils.hasName;

public class Armor implements hasName{
    private final String name;
    private final int defense;
    private final double magicResist;
    
    public Armor(String name, int defense, double magicResist){
        this.name = name;
        this.defense = defense;
        this.magicResist = magicResist;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    public int getDefense(){
        return defense;
    }
    
    public double getMagicResist(){
        return magicResist;
    }
}
