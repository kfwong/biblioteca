package com.twu.biblioteca;

import java.util.Optional;

public class CheckInMenu implements SelectableMenu {
    @Override
    public void execute(BibliotecaApp context, String... params) {
        String bookTitle = params[0];
        Library library = context.getLibrary();

        checkIn(library, bookTitle);

    }

    public void checkIn(Library library, String bookTitle){

        Optional<Book> book = library.findBookByTitle(bookTitle);

        if(book.isPresent()){
            library.checkIn(book.get());
        }else{
            System.out.println("This is not a valid book to return");
        }
    }
}
