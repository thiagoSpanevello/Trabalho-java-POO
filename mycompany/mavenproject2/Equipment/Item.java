package com.mycompany.mavenproject2.Equipment;

import com.mycompany.mavenproject2.Utils.hasName;

public class Item<K extends hasName>{
    public final K data;
    public final double price;
    public final boolean sellable;
    public final boolean stackable;
    private int currentStack;
    
    public Item(K data, double price, boolean sellable, boolean stackable, int currentStack) {
        this.data = data;
        this.price = price;
        this.sellable = sellable;
        this.stackable = stackable;
        this.currentStack = currentStack;
    }
    
    public Item(K data, double price, boolean sellable, boolean stackable) {
        this.data = data;
        this.price = price;
        this.sellable = sellable;
        this.stackable = stackable;
        this.currentStack = 1;
    }

    public int getCurrentStack() {
        return currentStack;
    }

    public void setCurrentStack(int currentStack) {
        this.currentStack = currentStack;
    }
    
    public void incrementStack() throws Exception {
        if(this.currentStack == 64) throw new Exception(Integer.toString(this.currentStack - 64));
        this.currentStack++;
    }
    
    public void incrementStack(int n) throws Exception {
        if(this.currentStack + n > 64) {
            int prev = this.currentStack;
            this.currentStack = 64;
            throw new Exception(Integer.toString(prev + n - 64));
        }

        this.currentStack+= n;
    }
    
    public void decreaseStack() throws Exception  {
        if(this.currentStack == 1) throw new Exception("Removido");
        this.currentStack++;
    }
}
