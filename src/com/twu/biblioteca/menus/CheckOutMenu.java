package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.library.Library;

import java.util.Optional;

public class CheckOutMenu implements Menu {
    @Override
    public void execute(BibliotecaApp context, String... params) {
        String bookTitle = params[0];
        Library library = context.getLibrary();

        checkOut(library, bookTitle);

    }

    public void checkOut(Library library, String bookTitle){

        Optional<Book> book = library.findAvailableBookByTitle(bookTitle);

        if(book.isPresent() && library.checkOut(book.get())){
            System.out.println("Thank you! Enjoy the book");
        }else{
            System.out.println("Sorry, that book is unavailable");
        }
    }
}
