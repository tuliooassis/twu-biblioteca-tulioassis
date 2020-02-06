package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.exceptions.InvalidOptionException;

import java.util.Scanner;

public class LibraryController {
    private static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    private BookController bookController;

    public Scanner scanner;

    public LibraryController(Scanner scanner, BookController bookController) {
        this.bookController = bookController;
        this.scanner = scanner;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void printMenu() {
        System.out.println("\n\n------ MENU ------");
        System.out.println("(1) List of books");
        System.out.println("(2) Checkout a book");
        System.out.println("(3) Return a book");
        System.out.println("(9) Exit");
    }

    public void doAction(int option) throws InvalidOptionException, ExitException {
        boolean success;

        switch (option) {
            case 1:
                System.out.println(this.bookController.getString());
                break;
            case 2:
                System.out.println("Enter one book code to checkout: ");
                success = this.bookController.checkOut(this.scanner.nextInt());

                if (success) {
                    System.out.println("Thank you! Enjoy the book!");
                } else {
                    System.out.println("Sorry, that book is not available.");
                }
                break;
            case 3:
                System.out.println("Enter one book code to return: ");
                success = this.bookController.checkIn(this.scanner.nextInt());

                if (success) {
                    System.out.println("Thank you for returning the book.");
                } else {
                    System.out.println("That is not a valid book to return.");
                }
                break;
            case 9:
                throw new ExitException();
            default:
                throw new InvalidOptionException();
        }
    }
}
