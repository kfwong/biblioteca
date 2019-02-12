package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;

public class LogOutMenu extends Menu {
    @Override
    public void execute(BibliotecaApp context, String... args) {
        context.logout();
    }
}
