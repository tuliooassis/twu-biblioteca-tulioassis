package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.BookModel;
import com.twu.biblioteca.repository.BooksRepository;

import java.util.ArrayList;

public class LibraryController {
    private String welcomeMessage;
    private BooksRepository booksRepository;

    public LibraryController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;

        this.welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String getWelcomeMessage() {
        return this.welcomeMessage;
    }

    public String getBooksString() {
        String booksString = "";

        for (BookModel book : this.booksRepository.getBooks()) {
            booksString += book.toString() + "\n";
        }

        return booksString;
    }
}
