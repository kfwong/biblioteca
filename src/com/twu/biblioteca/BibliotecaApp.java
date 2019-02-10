package com.twu.biblioteca;

import com.twu.biblioteca.library.BibliotecaLibrary;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.menus.Menu;
import com.twu.biblioteca.menus.SelectableMenu;

import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    private Library library;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new BibliotecaLibrary());

        bibliotecaApp.displayWelcomeMessage();

        while(true) {
            bibliotecaApp.displaySeparator("MENU");
            bibliotecaApp.displayMenu();
            bibliotecaApp.promptMenuChoice(scanner);
        }

    }

    public BibliotecaApp(Library libary){
        this.library = libary;
    }

    public Library getLibrary() {
        return library;
    }

    public void displaySeparator(String title){
        System.out.println("========="+title+"===========");
    }

    public void displayWelcomeMessage(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void displayMenu(){
        for(int i = 0; i < Menu.values().length; i++){
            final int index = i + 1;
            final Menu menu = Menu.values()[i];

            if(menu.isDisplayable()) {
                menu.setIndex(index);
                System.out.println(index + ". " + menu.getName());
            }
        }

    }

    public void promptMenuChoice(Scanner scanner){
        System.out.print("Your choice: ");

        if(scanner.hasNextInt()){
            final int choice = scanner.nextInt();
            final String params = scanner.nextLine().trim();
            selectMenu(choice, params);
        }else {
            scanner.next();
            selectMenu(-1);
        }
    }

    public void selectMenu(int index, String... params) {
        final SelectableMenu menu = Arrays.stream(Menu.values())
                .filter( m -> m.getIndex() == index)
                .findFirst()
                .orElse(Menu.INVALID)
                .getMenu();

        menu.execute(this, params);
    }
}
