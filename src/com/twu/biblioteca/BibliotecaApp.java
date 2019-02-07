package com.twu.biblioteca;

public class BibliotecaApp {

    private final String[] books = {"Harry Potter and the Deathly Hallows", "Fifty Shades of Grey"};

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.displayWelcomeMessage();
    }

    public void displayWelcomeMessage(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void displayListOfBooks(){
        System.out.println(String.join("\n", books));
    }
}
