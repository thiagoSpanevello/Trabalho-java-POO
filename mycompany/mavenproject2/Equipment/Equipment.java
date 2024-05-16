package com.mycompany.mavenproject2.Equipment;

public class Equipment {
    private Armor armor;
    private Pants pants;
    private Necklace necklace;
    private Ring ring;
    private Weapon weapon;

    public Equipment() {
    }

    public Armor getArmor() {
        return armor;
    }

    public Pants getPants() {
        return pants;
    }

    public Necklace getNecklace() {
        return necklace;
    }

    public Ring getRing() {
        return ring;
    }

    public Weapon getWeapon() {
        return weapon;
    }
    
    public Item equip(Item item){
        Item res = null;
        if (item.getItem() instanceof Armor){
            if(this.armor != null)  res = new Item(this.armor, true, false, 1);
            this.armor =(Armor) item.getItem();
            
            return res;
        }
        if (item.getItem() instanceof Pants){
            if(this.armor != null)  res = new Item(this.pants, true, false, 1);
            this.pants =(Pants) item.getItem();
            
            return res;
        }
        if (item.getItem() instanceof Necklace){
            if(this.necklace != null)  res = new Item(this.necklace, true, false, 1);
            this.necklace =(Necklace) item.getItem();
            
            return res;
        }
        if (item.getItem() instanceof Ring){
            if(this.ring != null)  res = new Item(this.ring, true, false, 1);
            this.ring =(Ring) item.getItem();
            
            return res;
        }
        
        if (item.getItem() instanceof Weapon){
            if(this.weapon != null)  res = new Item(this.weapon, true, false, 1);
            this.weapon =(Weapon) item.getItem();
            
            return res;
        }
        return res;
    }
    
}
