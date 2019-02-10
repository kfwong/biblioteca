package com.twu.biblioteca.menus;

import com.twu.biblioteca.menus.*;

public enum Menu {
    LIST_ALL_BOOKS("List all books", new ListAllBooksMenu(), true),
    CHECKOUT("Check Out book", new CheckOutMenu(), true),
    CHECKIN("Check In book", new CheckInMenu(), true),
    QUIT("Quit", new QuitMenu(), true),
    INVALID("Invalid menu", new InvalidMenu(), false);

    String name;
    SelectableMenu menu;
    int index;
    boolean isDisplayable;

    Menu(String name, SelectableMenu menu, boolean isDisplayable) {
        this.name = name;
        this.menu = menu;
        this.isDisplayable = isDisplayable;
    }

    public void setIndex(int index) {
        if(this.isDisplayable) this.index = index;
    }

    public String getName() {
        return name;
    }

    public SelectableMenu getMenu() {
        return menu;
    }

    public boolean isDisplayable() {
        return isDisplayable;
    }

    public int getIndex() {
        return index;
    }
}