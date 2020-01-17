package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.BookModel;

import java.util.ArrayList;

public class BooksRepository {
    private ArrayList<BookModel> books;

    public BooksRepository() {
        this.books = new ArrayList<BookModel>();

        this.books.add(new BookModel("Book 1", "Author 1", 1997));
        this.books.add(new BookModel("Book 2", "Author 1", 2000));
        this.books.add(new BookModel("Book 3", "Author 2", 2012));
    }

    public ArrayList<BookModel> getBooks() {
        return this.books;
    }
}
