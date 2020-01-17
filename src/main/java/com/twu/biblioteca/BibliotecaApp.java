package com.twu.biblioteca;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.repository.BooksRepository;

public class BibliotecaApp {

    public static void main(String[] args) {
        BooksRepository booksRepository = new BooksRepository();
        LibraryController libraryController = new LibraryController(booksRepository);

        System.out.println(libraryController.getWelcomeMessage());

        System.out.println("-- Library Books --");
        System.out.print(libraryController.getBooksString());
    }
}
