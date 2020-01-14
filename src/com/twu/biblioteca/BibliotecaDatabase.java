package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaDatabase {
    private ArrayList<Book> books;

    public BibliotecaDatabase() {
        this.books = new ArrayList<Book>();

        this.books.add(new Book("Book 1"));
        this.books.add(new Book("Book 2"));
        this.books.add(new Book("Book 3"));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
