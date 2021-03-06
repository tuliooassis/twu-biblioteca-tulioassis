package com.twu.biblioteca;

import com.twu.biblioteca.account.controller.AccountController;
import com.twu.biblioteca.account.model.User;
import com.twu.biblioteca.account.repository.UserRepository;
import com.twu.biblioteca.account.services.AccountService;
import com.twu.biblioteca.item.controller.ItemController;
import com.twu.biblioteca.item.exceptions.ExitException;
import com.twu.biblioteca.item.exceptions.InvalidOptionException;
import com.twu.biblioteca.item.model.Book;
import com.twu.biblioteca.item.model.Movie;
import com.twu.biblioteca.item.repository.Repository;
import com.twu.biblioteca.item.services.Service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        final String INVALID_OPTION_MESSAGE = "Please select a valid option!";

        UserRepository userRepository = new UserRepository();
        AccountService accountService = new AccountService(userRepository);
        AccountController accountController = new AccountController(accountService);

        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Book 1", "Author 1", 1997));
        books.add(new Book(3, "Book 3", "Author 2", 2012));
        books.add(new Book(2,"Book 2", "Author 1", 2000));

        books.get(1).checkOut(new User("111-1111", "pass"));

        Repository<Book> bookRepository = new Repository<>(books);
        Service<Book> bookService = new Service<>(bookRepository, accountController);
        ItemController<Book> bookController = new ItemController<>(bookService);


        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Title 1", "Director 1", 2020, 10.0));
        movies.add(new Movie(2, "Title 2", "Director 1", 2010, 6.0));
        movies.add(new Movie(3, "Title 3", "Director 2", 1998, 8.7));

        Repository<Movie> moviesRepository = new Repository<>(movies);
        Service<Movie> movieService = new Service<>(moviesRepository, accountController);
        ItemController<Movie> movieController = new ItemController<>(movieService);


        Scanner scanner = new Scanner(System.in);

        LibraryManager libraryManager = new LibraryManager(scanner, bookController, movieController, accountController);

        System.out.println(libraryManager.getWelcomeMessage());
        libraryManager.printMenu();

        while(scanner.hasNext()){
            try {
                libraryManager.doAction(scanner.nextInt());

                libraryManager.printMenu();
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
