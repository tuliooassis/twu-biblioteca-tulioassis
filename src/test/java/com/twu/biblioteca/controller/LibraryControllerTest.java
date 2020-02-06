package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.exceptions.InvalidOptionException;
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
public class LibraryControllerTest {
    @InjectMocks
    LibraryController libraryController;

    @Mock
    BookController bookController;

    @Mock
    Scanner scanner;

    @Before
    public void setup() {
        this.libraryController = new LibraryController(this.scanner, this.bookController);
    }

    @Test
    public void welcomeMessageShouldBeCorrect() {
        String welcomeMessageExpected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        String welcomeMessageAtual = this.libraryController.getWelcomeMessage();

        assertEquals(welcomeMessageExpected, welcomeMessageAtual);
    }

    @Test
    public void printMenuShouldExist() {
        this.libraryController.printMenu();
    }

    @Test(expected = InvalidOptionException.class)
    public void invalidActionShouldThowsAException() throws Exception {
        int option = -1;

        this.libraryController.doAction(option);
    }

    @Test(expected = ExitException.class)
    public void menuOption9ShouldThrowExitException() throws Exception {
        int option = 9;

        this.libraryController.doAction(option);
    }

    @Test
    public void menuOption1ShouldCallBookGetString() throws Exception {
        int option = 1;

        this.libraryController.doAction(option);

        Mockito.verify(this.bookController, Mockito.times(1)).getString();
    }

    @Test
    public void menuOption2ShouldCallBookCheckOut() throws Exception {
        int option = 2;
        int checkoutOption = 1;

        Mockito.when(this.scanner.nextInt()).thenReturn(checkoutOption);

        this.libraryController.doAction(option);

        Mockito.verify(this.bookController, Mockito.times(1)).checkOut(Mockito.eq(checkoutOption));
    }

    @Test
    public void menuOption3ShouldCallBookCheckIn() throws Exception {
        int option = 3;
        int checkInOption = 1;

        Mockito.when(this.scanner.nextInt()).thenReturn(checkInOption);

        this.libraryController.doAction(option);

        Mockito.verify(this.bookController, Mockito.times(1)).checkIn(Mockito.eq(checkInOption));
    }

}
