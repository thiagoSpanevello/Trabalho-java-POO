package com.ciscos.project.equipment;

import com.ciscos.project.utils.hasName;

public class Armor implements hasName{
    private final String name;
    public final int defense;
    public final double magicResist;
    
    public Armor(String name, int defense, double magicResist){
        this.name = name;
        this.defense = defense;
        this.magicResist = magicResist;
    }
    
    @Override
    public String getName(){
        return name;
    }
}
