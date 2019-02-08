package com.twu.biblioteca;

enum Menu {
    LIST_ALL_BOOKS("List all books", new ListAllBooksMenu());

    String name;
    SelectableMenu menu;
    Menu(String name, SelectableMenu menu) {
        this.name = name;
        this.menu = menu;
    }
}