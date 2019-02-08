package com.twu.biblioteca;

enum Menu {
    LIST_ALL_BOOKS("List all books", new ListAllBooksMenu(), true),
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
        if(this != INVALID) this.index = index;
    }
}