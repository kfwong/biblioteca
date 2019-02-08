package com.twu.biblioteca;

import java.util.Arrays;

public class BibliotecaApp {

    private BibliotecaDataSource dataSource;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new BibliotecaDataSource());

        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayMenu();

    }

    public BibliotecaApp(BibliotecaDataSource dataSource){
        this.dataSource = dataSource;
    }

    public void displayWelcomeMessage(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void displayMenu(){
        for(int i = 0; i < Menu.values().length; i++){
            System.out.println((i + 1) + ". " + Menu.values()[i].name);
        }

    }

    public void promptMenuChoice(){
        System.out.print("Your choice: ");
    }

    public void selectMenu(SelectableMenu menu){
        menu.execute(this);
    }

    public BibliotecaDataSource getDataSource() {
        return dataSource;
    }
}
