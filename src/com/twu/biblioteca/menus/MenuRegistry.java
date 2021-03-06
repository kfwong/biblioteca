package com.twu.biblioteca.menus;

public enum MenuRegistry {
    LIST_ALL_BOOKS("List all books", new ListAllBooksMenu(), true),
    CHECKOUT("Check Out book", new CheckOutMenu(), true),
    CHECKIN("Check In book", new CheckInMenu(), true),
    QUIT("Quit", new QuitMenu(), true),
    INVALID("Invalid menu", new InvalidMenu(), false);

    String name;
    Menu menu;
    int index;
    boolean isDisplayable;

    MenuRegistry(String name, Menu menu, boolean isDisplayable) {
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

    public Menu getMenu() {
        return menu;
    }

    public boolean isDisplayable() {
        return isDisplayable;
    }

    public int getIndex() {
        return index;
    }
}