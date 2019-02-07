package com.twu.biblioteca;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BibliotecaApp {

    private final Book[] books = {
            new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling", 2007),
            new Book("Fifty Shades of Grey", "E.L. James", 2011)};

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.displayWelcomeMessage();

        bibliotecaApp.displayListOfBooks();
    }

    public void displayWelcomeMessage(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void displayListOfBooks(){
        System.out.println(tabulateBooks());
    }

    public String tabulateHeader() {
        return "Title\tAuthor\tYear";
    }

    public String tabulateBooks(){
        return Arrays.asList(books).stream()
                .map( book -> book.getTitle() + "\t"+book.getAuthor() + "\t" + book.getYear())
                .collect(Collectors.joining("\n"));
    }


}
