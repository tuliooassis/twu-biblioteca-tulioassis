package com.twu.biblioteca;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.exceptions.InvalidOptionException;
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
            catch (ExitException ex) {
                System.exit(0);
            }
            catch (InvalidOptionException ex) {
                System.out.println("Please select a valid option!");

            }
        }
    }
}
