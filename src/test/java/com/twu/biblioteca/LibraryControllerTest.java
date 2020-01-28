package com.twu.biblioteca;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.exceptions.InvalidOptionException;
import com.twu.biblioteca.model.BookModel;
import com.twu.biblioteca.repository.BooksRepository;
import org.junit.Before;
import org.junit.Test;

import java.awt.print.Book;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;


public class LibraryControllerTest {
    BooksRepository mockedBooksRepository;
    LibraryController libraryController;

    @Before
    public void setup() {
        this.mockedBooksRepository = mock(BooksRepository.class);
        this.libraryController = new LibraryController(mockedBooksRepository);
    }

    @Test
    public void welcomeMessageShouldBeCorrect() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        assertEquals(welcomeMessage, this.libraryController.getWelcomeMessage());
    }

    @Test
    public void getBooksShouldBeCalled1Time() {
        this.libraryController.getBooksString();
        verify(this.mockedBooksRepository, times(1)).getAvailableBooks();
    }

    @Test
    public void printMenuShouldExist() {
        this.libraryController.printMenu();
    }

    @Test(expected = InvalidOptionException.class)
    public void invalidActionShouldThowAException() throws Exception {
        int option = -1;
        this.libraryController.doAction(option);
    }

    @Test
    public void menuOption1ShouldCallGetBooksString() throws Exception {
        int option = 1;

        LibraryController libraryControllerSpy = spy(new LibraryController(mock(BooksRepository.class)));
        libraryControllerSpy.doAction(option);
        verify(libraryControllerSpy).getBooksString();
    }

    @Test(expected = ExitException.class)
    public void menuOption9ShouldThrowExitException() throws Exception {
        int option = 9;
        this.libraryController.doAction(option);
    }

    @Test
    public void menuOption2ShouldCallBookCheckout() throws InvalidOptionException, ExitException {
        int option = 2;
        int checkoutOption = 1;

        BooksRepository booksRepository = mock(BooksRepository.class);
        LibraryController libraryControllerSpy = spy(new LibraryController(booksRepository));

        InputStream in = new ByteArrayInputStream(String.valueOf(checkoutOption).getBytes());
        System.setIn(in);

        libraryControllerSpy.doAction(option);

        verify(libraryControllerSpy, times(1)).checkoutBook(eq(checkoutOption));
    }

    @Test
    public void checkoutBookShouldCallGetAvailableBooksTwiceIfTheIdExists() {
        int bookId = 1;

        BookModel book = new BookModel(1, "Book 1", "Author 1", 1992);

        when(this.mockedBooksRepository.getBookById(eq(bookId))).thenReturn(book);
        when(this.mockedBooksRepository.getAvailableBooks()).thenReturn(new ArrayList<BookModel>(Arrays.asList(book)));

        this.libraryController.checkoutBook(bookId);
        verify(this.mockedBooksRepository, times(2)).getAvailableBooks();
    }

    @Test
    public void checkoutBookShouldCallGetAvailableBooksOneTimeIfItIsNotAvailable() {
        int bookId = 1;

        BookModel book = new BookModel(1, "Book 1", "Author 1", 1992);

        when(this.mockedBooksRepository.getBookById(eq(bookId))).thenReturn(book);
        when(this.mockedBooksRepository.getAvailableBooks()).thenReturn(new ArrayList<BookModel>());

        this.libraryController.checkoutBook(bookId);
        verify(this.mockedBooksRepository, times(1)).getAvailableBooks();

    }
}
