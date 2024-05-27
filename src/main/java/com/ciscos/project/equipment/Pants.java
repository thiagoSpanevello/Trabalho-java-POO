package com.ciscos.project.equipment;

import com.ciscos.project.utils.hasName;

public class Pants implements hasName{
    private final String name;
    public final double defense;
    public final double magicResist;
    
    public Pants(String name, double defense, double magicResist){
        this.name = name;
        this.defense = defense;
        this.magicResist = magicResist;
    }
    
    @Override
    public String getName(){
        return name;
    }
}
