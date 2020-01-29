package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.BookModel;

import java.util.ArrayList;

public class BooksRepository {
    private ArrayList<BookModel> books;

    public BooksRepository() {
        this.books = new ArrayList<BookModel>();

        this.books.add(new BookModel(1,"Book 1", "Author 1", 1997));
        this.books.add(new BookModel(3, "Book 3", "Author 2", 2012, true));
        this.books.add(new BookModel(2,"Book 2", "Author 1", 2000));
    }

    public ArrayList<BookModel> getBooks() {
        return this.books;
    }

    public ArrayList<BookModel> getAvailableBooks() {
        ArrayList<BookModel> availableBooks = new ArrayList<>();

        this.books.forEach((book -> {
            if (!book.isChecked())
                availableBooks.add(book);
        }));

        return availableBooks;
    }


    public BookModel getBookById(int bookId) {
        BookModel book = null;

        for (BookModel b : this.books){
            if (b.getId() == bookId)
                book = b;
        }

        return book;
    }

}
