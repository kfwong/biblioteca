package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ListAllBooksMenu implements SelectableMenu {
    public static final String TABULATE_HEADER_FORMAT = "%-20s%-40s%-20s%-20s";
    public static final String TABULATE_BOOKS_FORMAT = "%-20d%-40s%-20s%-20d";

    @Override
    public void execute(BibliotecaApp context, String ...params) {

        displayListOfBooks(context.getLibrary().availableBooks());

    }

    public void displayListOfBooks(Book[] books){
        System.out.println(tabulateHeader());
        System.out.println(tabulateBooks(books));
    }

    public String tabulateHeader() {

        return String.format(TABULATE_HEADER_FORMAT, "No.", "Title", "Author", "Year").trim();
    }

    public String tabulateBooks(Book[] books){
        return Arrays.asList(books).stream()
                .map( book -> String.format(TABULATE_BOOKS_FORMAT, Arrays.asList(books).indexOf(book) + 1, book.getTitle(), book.getAuthor(), book.getYear()).trim())
                .collect(Collectors.joining("\n"));
    }
}
