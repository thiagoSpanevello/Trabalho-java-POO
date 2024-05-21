package com.mycompany.mavenproject2.Equipment;
import com.mycompany.mavenproject2.Utils.hasName;

public class Item<K extends hasName>{
    public final int id;
    public final K data;
    public final double price;
    public final boolean sellable;
    public final boolean stackable;
    private int currentStack;
    
    static private int key = 1;

    public Item(K data, double price, boolean sellable, boolean stackable, int currentStack) {
        this.id = key;
        this.data = data;
        this.price = price;
        this.sellable = sellable;
        this.stackable = stackable;
        this.currentStack = currentStack;
        Item.key++;
    }
    
    public Item(K data, double price, boolean sellable, boolean stackable) {
        this.id = key;
        this.data = data;
        this.price = price;
        this.sellable = sellable;
        this.stackable = stackable;
        this.currentStack = 1;
        Item.key++;
    }

    public int getCurrentStack() {
        return currentStack;
    }

    public void setCurrentStack(int currentStack) {
        this.currentStack = currentStack;
    }
    
    public void incrementStack(){
        this.currentStack++;
    }
    
    public void decreaseStack(){
        this.currentStack++;
    }
}
