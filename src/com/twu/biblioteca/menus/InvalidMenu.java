package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;

public class InvalidMenu implements Menu {

    @Override
    public void execute(BibliotecaApp app, String ...params) {
        System.out.println("Please select a valid option!");
    }
}
