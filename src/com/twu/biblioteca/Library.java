package com.twu.biblioteca;

import java.util.*;

public abstract class Library {

    abstract Book[] getBookSource();

    private SortedSet<Book> bookAvailability = new TreeSet<>(Arrays.asList(getBookSource()));

    public void checkout(Book book) {
        if(bookAvailability.remove(book)){
            System.out.println("Thank you! Enjoy the book");
        }else{
            System.out.println("Sorry, that book is unavailable");
        };
    }

    public void checkin(Book book) {
        bookAvailability.add(book);
    }

    public boolean isAvailable(Book book){
        return bookAvailability.contains(book);
    }

    public Book[] availableBooks(){
        return bookAvailability.toArray(new Book[bookAvailability.size()]);
    }

}
