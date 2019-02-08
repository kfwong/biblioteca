package com.twu.biblioteca;

public class InvalidMenu implements SelectableMenu {

    @Override
    public void execute(BibliotecaApp app) {
        System.out.println("Please select a valid option!");
    }
}
