package com.twu.biblioteca;

enum Menu {
    LIST_ALL_BOOKS("List all books", new ListAllBooksMenu()),
    QUIT("Quit", new QuitMenu()),
    INVALID("Invalid menu", new InvalidMenu());

    String name;
    SelectableMenu menu;
    int index;

    Menu(String name, SelectableMenu menu) {
        this.name = name;
        this.menu = menu;
    }

    public void setIndex(int index) {
        if(this != INVALID) this.index = index;
    }
}