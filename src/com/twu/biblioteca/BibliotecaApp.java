package com.twu.biblioteca;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BibliotecaApp {

    public static final String TABULATE_HEADER_FORMAT = "%-40s%-20s%-20s";
    public static final String TABULATE_BOOKS_FORMAT = "%-40s%-20s%-20d";

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
        System.out.println(tabulateHeader());
        System.out.println(tabulateBooks());
    }

    public String tabulateHeader() {

        return String.format(TABULATE_HEADER_FORMAT, "Title", "Author", "Year");
    }

    public String tabulateBooks(){
        return Arrays.asList(books).stream()
                .map( book -> String.format(TABULATE_BOOKS_FORMAT, book.getTitle(), book.getAuthor(), book.getYear()))
                .collect(Collectors.joining("\n"));
    }


}
