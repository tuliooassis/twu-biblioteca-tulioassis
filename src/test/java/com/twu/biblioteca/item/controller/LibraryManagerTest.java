package com.twu.biblioteca.item.controller;

import com.twu.biblioteca.account.controller.AccountController;
import com.twu.biblioteca.account.model.User;
import com.twu.biblioteca.item.exceptions.ExitException;
import com.twu.biblioteca.item.exceptions.InvalidOptionException;
import com.twu.biblioteca.item.model.Book;
import com.twu.biblioteca.item.model.Movie;
import com.twu.biblioteca.LibraryManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LibraryManagerTest {
    @InjectMocks
    LibraryManager libraryManager;

    @Mock
    ItemController<Book> bookController;

    @Mock
    ItemController<Movie> movieController;

    @Mock
    Scanner scanner;

    @Mock
    AccountController accountController;

    @Before
    public void setup() {
        this.libraryManager = new LibraryManager(this.scanner, this.bookController, this.movieController, this.accountController);
    }

    @Test
    public void welcomeMessageShouldBeCorrect() {
        String welcomeMessageExpected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        String welcomeMessageAtual = this.libraryManager.getWelcomeMessage();

        assertEquals(welcomeMessageExpected, welcomeMessageAtual);
    }

    @Test
    public void printMenuShouldExist() {
        this.libraryManager.printMenu();
    }

    @Test(expected = InvalidOptionException.class)
    public void invalidActionShouldThowsAException() throws Exception {
        int option = -1;

        this.libraryManager.doAction(option);
    }

    @Test(expected = ExitException.class)
    public void menuOption9ShouldThrowExitException() throws Exception {
        int option = 9;

        this.libraryManager.doAction(option);
    }

    @Test
    public void menuOption1ShouldCallBookGetString() throws Exception {
        int option = 1;

        this.libraryManager.doAction(option);

        Mockito.verify(this.bookController, Mockito.times(1)).getString();
    }

    @Test
    public void menuOption2ShouldCallBookCheckOut() throws Exception {
        int option = 2;
        int checkoutOption = 1;

        Mockito.when(this.scanner.nextInt()).thenReturn(checkoutOption);

        this.libraryManager.doAction(option);

        Mockito.verify(this.bookController, Mockito.times(1)).checkOut(Mockito.eq(checkoutOption));
    }

    @Test
    public void menuOption3ShouldCallBookCheckIn() throws Exception {
        int option = 3;
        int checkInOption = 1;

        Mockito.when(this.scanner.nextInt()).thenReturn(checkInOption);

        this.libraryManager.doAction(option);

        Mockito.verify(this.bookController, Mockito.times(1)).checkIn(Mockito.eq(checkInOption));
    }

    @Test
    public void menuOption4ShouldCallMovieGetString() throws Exception {
        int option = 4;

        this.libraryManager.doAction(option);

        Mockito.verify(this.movieController, Mockito.times(1)).getString();
    }

    @Test
    public void menuOption0ShouldDoLogIn() throws InvalidOptionException, ExitException {
        int option = 0;

        Mockito.when(this.scanner.nextLine()).thenReturn("\n", "111-1111", "pass");
        Mockito.when(this.accountController.login(Mockito.eq("111-1111"), Mockito.eq("pass"))).thenReturn(true);

        this.libraryManager.doAction(option);

        Mockito.verify(this.accountController, Mockito.times(1)).login(Mockito.eq("111-1111"), Mockito.eq("pass"));
    }

    @Test
    public void menuOption8ShouldDoLogOut() throws InvalidOptionException, ExitException {
        int option = 8;

        this.libraryManager.doAction(option);

        Mockito.verify(this.accountController, Mockito.times(1)).logout();
    }

    @Test
    public void menuOption7ShouldGetLoggedUser() throws InvalidOptionException, ExitException {
        int option = 7;
        User user = new User("111-1111", "pass", "User 1", "user@user", "+99 99 99999999");

        Mockito.when(this.accountController.getLoggedUser()).thenReturn(user);
        this.libraryManager.doAction(option);

        Mockito.verify(this.accountController, Mockito.times(1)).getLoggedUser();
    }
}
