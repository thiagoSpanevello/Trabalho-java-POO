package com.mycompany.mavenproject2.Equipment;

public class Equipment {

    private Item armor;
    private Item pants;
    private Item necklace;
    private Item ring;
    private Item weapon;

    public Equipment() {
    }

    public Armor getArmor() {
        return (Armor) armor.data;
    }

    public Pants getPants() {
        return (Pants) pants.data;
    }

    public Necklace getNecklace() {
        return (Necklace) necklace.data;
    }

    public Ring getRing() {
        return (Ring) ring.data;
    }

    public Weapon getWeapon() {
        return (Weapon) weapon.data;
    }

    public Item equip(Item item) throws Exception {
        Item res = null;
        if (item.data instanceof Armor) {
            if (this.armor != null) {
                res = this.armor;
            }
            this.armor = item;
        }
        else if (item.data instanceof Pants) {
            if (this.armor != null) {
                res = this.pants;
            }
            this.pants = item;
        }
        else if (item.data instanceof Necklace) {
            if (this.necklace != null) {
                res = this.necklace;
            }
            this.necklace = item;
        }
        else if (item.data instanceof Ring) {
            if (this.ring != null) {
                res = this.ring;
            }
            this.ring = item;
        }

        else if (item.data instanceof Weapon) {
            if (this.weapon != null) {
                res = this.weapon;
            }
            this.weapon = item;
        }
        
        else {
            throw new Exception("Não equipável.");
        }
        
        return res;
    }

}
