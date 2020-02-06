package com.twu.biblioteca;

import com.twu.biblioteca.item.controller.ItemController;
import com.twu.biblioteca.item.exceptions.ExitException;
import com.twu.biblioteca.item.exceptions.InvalidOptionException;
import com.twu.biblioteca.item.model.Book;
import com.twu.biblioteca.item.model.Movie;

import java.util.Scanner;

public class LibraryManager {
    private static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    private ItemController<Book> bookController;
    private ItemController<Movie> movieController;

    public Scanner scanner;

    public LibraryManager(Scanner scanner, ItemController<Book> bookController, ItemController<Movie> movieController) {
        this.bookController = bookController;
        this.movieController = movieController;
        this.scanner = scanner;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void printMenu() {
        System.out.println("\n\n------ MENU ------");
        System.out.println("* BOOKS *");
        System.out.println("(1) List of books");
        System.out.println("(2) Checkout a book");
        System.out.println("(3) Return a book");

        System.out.println("* MOVIES *");
        System.out.println("(4) List of movies");
        System.out.println("(5) Checkout a movie");

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
            case 4:
                System.out.println(this.movieController.getString());
                break;
            case 5:
                System.out.println("Enter one movie code to checkout: ");
                success = this.movieController.checkOut(this.scanner.nextInt());

                if (success) {
                    System.out.println("Thank you! Enjoy the movie!");
                } else {
                    System.out.println("Sorry, that movie is not available.");
                }
                break;
            case 9:
                throw new ExitException();
            default:
                throw new InvalidOptionException();
        }
    }
}
