package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;

public class BooksRepository {
    private ArrayList<Book> books;

    public BooksRepository() {
        this.books = new ArrayList<Book>();

        this.books.add(new Book(1,"Book 1", "Author 1", 1997));
        this.books.add(new Book(3, "Book 3", "Author 2", 2012, true));
        this.books.add(new Book(2,"Book 2", "Author 1", 2000));
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();

        this.books.forEach((book -> {
            if (!book.isChecked())
                availableBooks.add(book);
        }));

        return availableBooks;
    }


    public Book getBookById(int bookId) {
        Book book = null;

        for (Book b : this.books){
            if (b.getId() == bookId)
                book = b;
        }

        return book;
    }

}
