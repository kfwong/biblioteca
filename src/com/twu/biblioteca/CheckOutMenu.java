package com.twu.biblioteca;

import java.util.Optional;

public class CheckOutMenu implements SelectableMenu {
    @Override
    public void execute(BibliotecaApp context, String ...params) {
        String bookTitle = params[0];
        Library library = context.getLibrary();

        Optional<Book> book = library.findBookByTitle(bookTitle);

        if(book.isPresent()){
            library.checkout(book.get());
        }else{
            System.out.println("Sorry, that book is unavailable");
        }

    }
}
