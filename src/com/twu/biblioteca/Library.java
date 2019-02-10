package com.twu.biblioteca;

import java.util.Arrays;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class Library {

    abstract Book[] getBookSource();

    private SortedSet<Book> bookAvailability = new TreeSet<>(Arrays.asList(getBookSource()));

    public void checkOut(Book book) {
        if(bookAvailability.remove(book)){
            System.out.println("Thank you! Enjoy the book");
        }else{
            System.out.println("Sorry, that book is unavailable");
        };
    }

    public void checkIn(Book book) {
        if(bookAvailability.add(book)){
            System.out.println("Thank you for returning the book");
        }else{
            System.out.println("This is not a valid book to return");
        }
    }

    public boolean isAvailable(Book book){
        return bookAvailability.contains(book);
    }

    public Book[] availableBooks(){
        return bookAvailability.toArray(new Book[0]);
    }

    public Optional<Book> findAvailableBookByTitle(String title){
        return bookAvailability.stream()
                .filter( book -> book.getTitle().equals(title))
                .findFirst();
    }

    public Optional<Book> findBookByTitle(String title){
        return Arrays.stream(getBookSource())
                .filter( b -> b.getTitle().equals(title))
                .findFirst();
    }

}
