package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.BookModel;

import java.util.ArrayList;

public class BooksRepository {
    private ArrayList<BookModel> bookModels;

    public BooksRepository() {
        this.bookModels = new ArrayList<BookModel>();

        this.bookModels.add(new BookModel("Book 1", "Author 1", 1997));
        this.bookModels.add(new BookModel("Book 2", "Author 1", 2000));
        this.bookModels.add(new BookModel("Book 3", "Author 2", 2012));
    }

    public ArrayList<BookModel> getBookModels() {
        return bookModels;
    }
}
