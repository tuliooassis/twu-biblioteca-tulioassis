package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.exceptions.InvalidOptionException;
import com.twu.biblioteca.model.BookModel;
import com.twu.biblioteca.repository.BooksRepository;

import java.util.ArrayList;
import java.util.Scanner;

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

    public boolean checkoutBook(int bookId){
        BookModel bookRecovered = this.booksRepository.getBookById(bookId);
        int indexOfBook = this.booksRepository.getAvailableBooks().indexOf(bookRecovered);

        if(indexOfBook != -1){
            this.booksRepository.getAvailableBooks().get(indexOfBook).checkout();
            return true;
        }
        return false;
    }

    public boolean checkinBook(int bookId) {
        BookModel bookRecovered = this.booksRepository.getBookById(bookId);

        if(bookRecovered != null && !this.booksRepository.getAvailableBooks().contains(bookRecovered)){
            bookRecovered.checkin();
            return true;
        }
        return false;
    }

    public void printMenu() {
        System.out.println("\n\n------ MENU ------");
        System.out.println("(1) List of books");
        System.out.println("(2) Checkout a book");
        System.out.println("(3) Return a book");
        System.out.println("(9) Exit");
    }

    public void doAction(int option) throws InvalidOptionException, ExitException {
            Scanner scanner = new Scanner(System.in);
            boolean success;

            switch (option) {
                case 1:
                    System.out.println("-- Library Books --");
                    System.out.println(this.getBooksString());
                    break;
                case 2:
                    this.doAction(1);
                    System.out.println("Enter one book code to checkout: ");

                    success = this.checkoutBook(scanner.nextInt());
                    if (success) {
                        System.out.println("Thank you! Enjoy the book!");
                    }
                    else {
                        System.out.println("Sorry, that book is not available.");
                    }
                    break;
                case 3:
                    System.out.println("Enter one book code to return: ");
                    success = this.checkinBook(scanner.nextInt());

                    if (success) {
                        System.out.println("Thank you for returning the book.");
                    }
                    else {
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
