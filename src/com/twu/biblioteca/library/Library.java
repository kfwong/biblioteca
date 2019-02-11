package com.twu.biblioteca.library;

import com.twu.biblioteca.Book;

import java.util.Arrays;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class Library {

    public abstract Book[] getBookSource();

    private SortedSet<Book> bookAvailability = new TreeSet<>(Arrays.asList(getBookSource()));

    public boolean checkOut(Book book) {
        return bookAvailability.remove(book);
    }

    public boolean checkIn(Book book) {
        return bookAvailability.add(book);
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
