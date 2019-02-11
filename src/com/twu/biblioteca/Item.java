package com.twu.biblioteca;

public class Item implements Comparable<Item>{

    protected String title;

    public Item(String title){
        this.title = title;
    }

    @Override
    public int compareTo(Item other) {
        return this.title.compareTo(other.title);
    }
}
