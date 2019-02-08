package com.twu.biblioteca;

import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    private BibliotecaDataSource dataSource;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new BibliotecaDataSource());

        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayMenu();
        bibliotecaApp.promptMenuChoice();

    }

    public BibliotecaApp(BibliotecaDataSource dataSource){
        this.dataSource = dataSource;
    }

    public void displayWelcomeMessage(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void displayMenu(){
        for(int i = 0; i < Menu.values().length; i++){
            final int index = i + 1;
            Menu.values()[i].setIndex(index);
            System.out.println(index + ". " + Menu.values()[i].name);
        }

    }

    public void promptMenuChoice(){
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print("Your choice: ");
            final int choice = input.nextInt();

            selectMenu(choice);
        }
    }

    public void selectMenu(int index) {
        final SelectableMenu menu = Arrays.stream(Menu.values())
                .filter( m -> m.index == index)
                .findFirst()
                .orElse(Menu.INVALID)
                .menu;

        menu.execute(this);
    }

    public BibliotecaDataSource getDataSource() {
        return dataSource;
    }
}
