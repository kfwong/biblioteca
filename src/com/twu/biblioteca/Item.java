package com.twu.biblioteca;

public abstract class Item implements Comparable<Item>{

    protected String title;

    public abstract String displayFormat();

    public Item(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Item other) {
        return this.title.compareTo(other.title);
    }
}
