package com.twu.biblioteca;

import com.twu.biblioteca.controller.LibraryController;

public class BibliotecaApp {

    public static void main(String[] args) {
        LibraryController libraryController = new LibraryController();

        System.out.println(libraryController.getWelcomeMessage());

        System.out.println("-- Library Books --");
        System.out.print(libraryController.getBooksString());
    }
}
