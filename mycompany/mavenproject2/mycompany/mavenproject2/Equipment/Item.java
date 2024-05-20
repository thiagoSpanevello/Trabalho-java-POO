package com.mycompany.mavenproject2.Equipment;
import com.mycompany.mavenproject2.Utils.hasName;

public class Item<K extends hasName>{
    private final K item;
    private final boolean sellable;
    private final boolean stackable;
    private int currentStack;

    public Item(K item, boolean sellable, boolean stackable, int currentStack) {
        this.item = item;
        this.sellable = sellable;
        this.stackable = stackable;
        this.currentStack = currentStack;
    }

    public K getItem() {
        return item;
    }

    public boolean isSellable() {
        return sellable;
    }

    public boolean isStackable() {
        return stackable;
    }

    public int getCurrentStack() {
        return currentStack;
    }

    public void setCurrentStack(int currentStack) {
        this.currentStack = currentStack;
    }
}
