package com.ciscos.project.items;

import com.ciscos.project.utils.hasName;

public class Item<K extends hasName>{
    public final K data;
    public final double price;
    public final boolean sellable;
    private int currentStack;    
    public final int maxStack;

    
    public Item(K data, double price, boolean sellable, int currentStack, int maxStack) {
        this.data = data;
        this.price = price;
        this.sellable = sellable;
        this.currentStack = currentStack;
        this.maxStack = maxStack;
    }
    
    public Item(K data, double price, boolean sellable, int maxStack) {
        this.data = data;
        this.price = price;
        this.sellable = sellable;
        this.currentStack = 1;
        this.maxStack = maxStack;
    }

    public int getCurrentStack() {
        return currentStack;
    }

    public void setCurrentStack(int currentStack) {
        this.currentStack = currentStack;
    }
    
    public void incrementStack() throws Exception {
        if(this.currentStack == this.maxStack) throw new Exception(Integer.toString(this.currentStack - this.maxStack));
        this.currentStack++;
    }
    
    public void incrementStack(int n) throws Exception {
        if(this.currentStack + n > this.maxStack) {
            int prev = this.currentStack;
            this.currentStack = this.maxStack;
            throw new Exception(Integer.toString(prev + n - this.maxStack));
        }

        this.currentStack+= n;
    }
    
    public void decreaseStack() throws Exception  {
        if(this.currentStack == 1) throw new Exception("Removido");
        this.currentStack++;
    }
}
