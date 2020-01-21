package com.twu.biblioteca;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.repository.BooksRepository;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BooksRepository booksRepository = new BooksRepository();
        LibraryController libraryController = new LibraryController(booksRepository);

        libraryController.printMenu();

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            try {
                libraryController.doAction(scanner.nextInt());
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
