package com.twu.biblioteca;

import com.twu.biblioteca.account.controller.AccountController;
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

    private AccountController accountController;

    public Scanner scanner;

    public LibraryManager(Scanner scanner, ItemController<Book> bookController, ItemController<Movie> movieController, AccountController accountController) {
        this.bookController = bookController;
        this.movieController = movieController;
        this.scanner = scanner;
        this.accountController = accountController;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void printMenu() {
        System.out.println("\n\n------ MENU ------");

        if (this.accountController.getLoggedUser() != null)
            printLoggedMenu();
        else
            System.out.println("(0) Login");

        System.out.println("(9) Exit");
    }

    private void printLoggedMenu() {
        System.out.println("* BOOKS *");
        System.out.println("(1) List of books");
        System.out.println("(2) Checkout a book");
        System.out.println("(3) Return a book");

        System.out.println("* MOVIES *");
        System.out.println("(4) List of movies");
        System.out.println("(5) Checkout a movie");

        System.out.println("\n(7) My information");
        System.out.println("(8) Logout");
    }

    public void doAction(int option) throws InvalidOptionException, ExitException {
        boolean success;

        switch (option) {
            case 0:
                boolean logged;
                String libraryNumber;
                String password;
                scanner.nextLine();
                System.out.println("Library Number: ");
                libraryNumber = scanner.nextLine();
                System.out.println("Password: ");
                password = scanner.nextLine();

                logged = accountController.login(libraryNumber, password);

                if (!logged)
                    System.out.println("Wrong credentials, please try again.\n");
                else
                    System.out.println("Everything right!\n");
                break;
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
            case 7:
                System.out.println(this.accountController.getLoggedUser().toString());
                break;
            case 8:
                this.accountController.logout();
                System.out.println("Success!\n");
                break;
            case 9:
                throw new ExitException();
            default:
                throw new InvalidOptionException();
        }
    }
}
