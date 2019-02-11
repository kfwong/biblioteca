package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.library.Library;

import java.util.Optional;

public class CheckInMenu implements Menu {
    @Override
    public void execute(BibliotecaApp context, String... params) {
        String bookTitle = params[0];
        Library library = context.getLibrary();

        checkIn(library, bookTitle);

    }

    public void checkIn(Library library, String bookTitle){

        Optional<Book> book = library.findBookByTitle(bookTitle);

        if(book.isPresent() && library.checkIn(book.get())){
            System.out.println("Thank you for returning the book");
        }else{
            System.out.println("This is not a valid book to return");
        }
    }
}
