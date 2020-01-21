package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.exceptions.InvalidOptionException;
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
        ArrayList<BookModel> books = this.booksRepository.getAvailableBooks();

        for (BookModel book : books) {
            booksString += book.toString() + "\n";
        }

        return booksString;
    }

    public void printMenu() {
        System.out.println("-- MENU --");
        System.out.println("(1) List of books");
        System.out.println("(9) Exit");
    }

    public void doAction(int option) throws InvalidOptionException, ExitException {
            switch (option) {
                case 1:
                    System.out.println("-- Library Books --");
                    System.out.println(this.getBooksString());
                    break;
                case 9:
                    throw new ExitException();
                default:
                    throw new InvalidOptionException();
            }
    }
}
