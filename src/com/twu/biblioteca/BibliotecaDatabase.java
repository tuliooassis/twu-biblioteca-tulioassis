package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Date;

public class BibliotecaDatabase {
    private ArrayList<Book> books;

    public BibliotecaDatabase() {
        this.books = new ArrayList<Book>();

        this.books.add(new Book("Book 1", "Author 1", 1997));
        this.books.add(new Book("Book 2", "Author 1", 2000));
        this.books.add(new Book("Book 3", "Author 2", 2012));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
