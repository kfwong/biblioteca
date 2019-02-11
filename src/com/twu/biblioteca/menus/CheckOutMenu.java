package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.library.Library;

import java.util.Arrays;
import java.util.Optional;

public class CheckOutMenu extends Menu {
    @Override
    public void execute(BibliotecaApp context, String... params) {
        String title = params[0];
        Library library = context.getLibrary();

        checkOut(library, title);

    }

    public void checkOut(Library library, String title){

        Optional<Item> item = library.findAvailableItemByTitle(title, Arrays.asList(library.getItemSource()));


        if(item.isPresent() && library.checkOut(item.get())){
            String type = item.get().getClass().getSimpleName().toLowerCase();
            System.out.println("Thank you! Enjoy the " + type);
        }else{
            System.out.println("Sorry, that item is unavailable");
        }
    }
}
