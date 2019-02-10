package com.twu.biblioteca;

import com.twu.biblioteca.menus.*;

enum Menu {
    LIST_ALL_BOOKS("List all books", new ListAllBooksMenu(), true),
    CHECKOUT("Checkout book", new CheckOutMenu(), true),
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
}