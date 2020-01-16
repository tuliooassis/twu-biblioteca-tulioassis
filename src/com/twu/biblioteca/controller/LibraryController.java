package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.BookModel;
import com.twu.biblioteca.repository.BooksRepository;

import java.util.ArrayList;

public class LibraryController {
    private String welcomeMessage;
    private ArrayList<BookModel> bookModels;

    public LibraryController() {
        BooksRepository booksRepository = new BooksRepository();
        this.bookModels = booksRepository.getBookModels();

        this.welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String getWelcomeMessage() {
        return this.welcomeMessage;
    }

    public String getBooksString() {
        String booksString = "";

        for (BookModel bookModel : this.bookModels) {
            booksString += bookModel.toString() + "\n";
        }

        return booksString;
    }
}
