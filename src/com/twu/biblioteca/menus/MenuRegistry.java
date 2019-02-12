package com.twu.biblioteca.menus;

public enum MenuRegistry {
    LIST_ALL_BOOKS("List all items", new ListAllItemsMenu(), true, false),
    CHECKOUT("Check out item", new CheckOutMenu(), true, true),
    CHECKIN("Check in item", new CheckInMenu(), true, true),
    LOGIN("Login", new LogInMenu(), true, false),
    LOGOUT("Logout", new LogOutMenu(), true, false),
    QUIT("Quit", new QuitMenu(), true, false),
    INVALID("Invalid menu", new InvalidMenu(), false, false);

    String name;
    Menu menu;
    int index;
    boolean isDisplayable;
    boolean isAuthenticable;

    MenuRegistry(String name, Menu menu, boolean isDisplayable, boolean isAuthenticable) {
        this.name = name;
        this.menu = menu;
        this.isDisplayable = isDisplayable;
        this.isAuthenticable = isAuthenticable;
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

    public boolean isAuthenticable() {
        return isAuthenticable;
    }

    public int getIndex() {
        return index;
    }
}