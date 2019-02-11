package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.library.Library;

import java.util.Arrays;
import java.util.Optional;

public class CheckInMenu implements Menu{
    @Override
    public void execute(BibliotecaApp context, String... params) {
        String bookTitle = params[0];
        Library library = context.getLibrary();

        checkIn(library, bookTitle);

    }

    public void checkIn(Library library, String bookTitle){

        Optional<Item> item = library.findItemByTitle(bookTitle, Arrays.asList(library.getItemSource()));

        if(item.isPresent() && library.checkIn(item.get())){
            String type = item.get().getClass().getSimpleName().toLowerCase();
            System.out.println("Thank you for returning the "+ type);
        }else{
            System.out.println("This is not a valid item to return");
        }
    }
}
