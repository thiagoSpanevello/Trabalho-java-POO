package com.ciscos.project.berserker;

import com.ciscos.project.Character;
import com.ciscos.project.utils.Damage;

public class Berserker extends Character{
    private int strength;
    private int currentStrength;
    private double critRate;
    public double rageCritRate;
    private int inRage;
    
    public Berserker(String name, double hp, int speed, int strength, double critRate){
        super(name, hp, speed);
        this.strength = strength;
        this.critRate = critRate;
        this.currentStrength = strength;
        this.rageCritRate = critRate;
        this.inRage = 0;
    }
    
    public void checkRage(){
        if(this.getHp() < this.getMaxHp()*0.5 && inRage < 1){
               inRage = 1;
               if(this.getHp() < this.getMaxHp()*0.25){
                   inRage = 2;
               }
        }
    }
    
    @Override
    public void restore(){
        super.restore();
        
        double newStrength = this.strength * 1.1;
        this.strength = (int) Math.ceil(newStrength);
        
        inRage = 0;
        this.currentStrength = this.strength;
        this.rageCritRate = this.critRate;
    }
    
    
    @Override
    public Damage attack(){
        return new Damage(0, "physical");
    }
}
