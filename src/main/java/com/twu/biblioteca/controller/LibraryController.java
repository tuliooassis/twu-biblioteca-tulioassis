package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.BookModel;
import com.twu.biblioteca.repository.BooksRepository;

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

    public void printMenu() {
        System.out.println("-- MENU --");
        System.out.println("(1) List of books");
        System.out.println("(9) Exit");
    }

    public void doAction(int option) throws Exception {
        switch (option) {
            case 1:
                System.out.println("-- Library Books --");
                System.out.println(this.getBooksString());
                break;
            case 9:
                System.exit(0);
                break;
            default:
                throw new Exception("Please select a valid option!");
        }
    }
}
