package com.mycompany.mavenproject2.Utils;

public class Damage {
    public final double damage;
    public final String type;

    public Damage(double damage, String type) {
        if(type == "magic") this.type = "magicResist";
        else this.type = "defense";
        this.damage = damage;
    }
}
