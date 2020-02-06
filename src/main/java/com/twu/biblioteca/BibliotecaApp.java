package com.twu.biblioteca;

import com.twu.biblioteca.controller.BookController;
import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.exceptions.InvalidOptionException;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.Repository;
import com.twu.biblioteca.services.Service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        final String INVALID_OPTION_MESSAGE = "Please select a valid option!";

        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Book 1", "Author 1", 1997));
        books.add(new Book(3, "Book 3", "Author 2", 2012, true));
        books.add(new Book(2,"Book 2", "Author 1", 2000));

        Repository<Book> bookRepository = new Repository<>(books);
        Service<Book> bookService = new Service<>(bookRepository);
        BookController bookController = new BookController(bookService);

        Scanner scanner = new Scanner(System.in);

        LibraryController libraryController = new LibraryController(scanner, bookController);

        libraryController.printMenu();

        while(scanner.hasNext()){
            try {
                libraryController.doAction(scanner.nextInt());

                libraryController.printMenu();
            }
            catch (ExitException ex) {
                System.exit(0);
            }
            catch (InvalidOptionException ex) {
                System.out.println(INVALID_OPTION_MESSAGE);
            }
            catch (InputMismatchException ex){
                System.out.println(INVALID_OPTION_MESSAGE);
                scanner.next();
            }
        }
    }
}
