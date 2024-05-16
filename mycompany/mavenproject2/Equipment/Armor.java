/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2.Equipment;

/**
 *
 * @author aluno
 */
public class Armor {
    private final String name;
    private final int defense;
    private final double magicResist;
    
    public Armor(String name, int defense, double magicResist){
        this.name = name;
        this.defense = defense;
        this.magicResist = magicResist;
    }
    
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
