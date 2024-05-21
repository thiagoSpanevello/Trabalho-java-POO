/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2.Equipment;

import com.mycompany.mavenproject2.Utils.hasName;

/**
 *
 * @author aluno
 */
public class Pants implements hasName{
    private final String name;
    private final int defense;
    private final double magicResist;
    
    public Pants(String name, int defense, double magicResist){
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
