package com.twu.biblioteca;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ListAllBooksMenu implements SelectableMenu {
    public static final String TABULATE_HEADER_FORMAT = "%-40s%-20s%-20s";
    public static final String TABULATE_BOOKS_FORMAT = "%-40s%-20s%-20d";

    @Override
    public void execute(BibliotecaApp context) {

        displayListOfBooks(context.getDataSource().getBooks());

    }

    public void displayListOfBooks(Book[] books){
        System.out.println(tabulateHeader());
        System.out.println(tabulateBooks(books));
    }

    public String tabulateHeader() {

        return String.format(TABULATE_HEADER_FORMAT, "Title", "Author", "Year");
    }

    public String tabulateBooks(Book[] books){
        return Arrays.asList(books).stream()
                .map( book -> String.format(TABULATE_BOOKS_FORMAT, book.getTitle(), book.getAuthor(), book.getYear()))
                .collect(Collectors.joining("\n"));
    }
}
