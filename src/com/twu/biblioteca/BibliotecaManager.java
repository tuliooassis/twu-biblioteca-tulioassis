package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaManager {
    private String welcomeMessage;
    private ArrayList<Book> books;

    public BibliotecaManager() {
        BibliotecaDatabase bibliotecaDatabase = new BibliotecaDatabase();
        this.books = bibliotecaDatabase.getBooks();

        this.welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String getWelcomeMessage() {
        return this.welcomeMessage;
    }

    public String getBooksString() {
        String booksString = "";

        for (Book book: this.books) {
            booksString += book.toString() + "\n";
        }

        return booksString;
    }
}
