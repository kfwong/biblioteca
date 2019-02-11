package com.twu.biblioteca.library;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Item;

import java.util.*;

public abstract class Library {

    public abstract Item[] getItemSource();

    private SortedSet<Item> itemAvailability = new TreeSet<>(Arrays.asList(getItemSource()));

    public boolean checkOut(Item item) {
        return itemAvailability.remove(item);
    }

    public boolean checkIn(Item item) {
        return itemAvailability.add(item);
    }

    public boolean isAvailable(Item item){
        return itemAvailability.contains(item);
    }

    public Item[] availableItems(){
        return itemAvailability.toArray(new Item[0]);
    }

    public Optional<Item> findAvailableItemByTitle(String title){
        return itemAvailability.stream()
                .filter( book -> book.getTitle().equals(title))
                .findFirst();
    }

    public Optional<Item> findItemByTitle(String title){
        return Arrays.stream(getItemSource())
                .filter( b -> b.getTitle().equals(title))
                .findFirst();
    }

    public <T extends Item> Optional<T> findAvailableItemByTitle(String title, Collection<T> collection){
        return collection.stream()
                .filter( c -> c.getTitle().equals(title))
                .findFirst();
    }

    public <T extends Item> Optional<T> findItemByTitle(String title, Collection<T> collection){
        return collection.stream()
                .filter( b -> b.getTitle().equals(title))
                .findFirst();
    }

}
