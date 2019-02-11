package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Item;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ListAllBooksMenu implements Menu {
    public static final String TABULATE_HEADER_FORMAT = "%-20s%-40s%-20s%-20s";
    public static final String TABULATE_FORMAT = "%-20d%s";

    @Override
    public void execute(BibliotecaApp context, String ...params) {

        displayListOfBooks(context.getLibrary().availableItems());

    }

    public void displayListOfBooks(Item[] items){
        System.out.println(tabulateHeader());
        System.out.println(tabulateBooks(items));
    }

    public String tabulateHeader() {

        return String.format(TABULATE_HEADER_FORMAT, "No.", "Title", "Author", "Year").trim();
    }

    public String tabulateBooks(Item[] items){
        return Arrays.stream(items)
                .map( book -> String.format(TABULATE_FORMAT, Arrays.asList(items).indexOf(book) + 1, book.displayFormat()).trim())
                .collect(Collectors.joining("\n"));
    }
}
