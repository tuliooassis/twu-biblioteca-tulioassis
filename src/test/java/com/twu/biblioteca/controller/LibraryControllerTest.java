package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.NotFoundException;
import com.twu.biblioteca.exceptions.ExitException;
import com.twu.biblioteca.exceptions.InvalidOptionException;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.BooksRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;


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
        verify(this.mockedBooksRepository, times(1)).getAvailableList();
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

//    TODO: How do tests with user inputs?
//    @Test
//    public void menuOption2ShouldCallBookCheckout() throws InvalidOptionException, ExitException {
//        int option = 2;
//        int checkoutOption = 1;
//
//        BooksRepository booksRepository = mock(BooksRepository.class);
//        LibraryController libraryControllerSpy = spy(new LibraryController(booksRepository));
//
//        InputStream in = new ByteArrayInputStream(String.valueOf(checkoutOption).getBytes());
//        System.setIn(in);
//
//        libraryControllerSpy.doAction(option);
//
//        verify(libraryControllerSpy, times(1)).checkoutBook(eq(checkoutOption));
//    }

    @Test
    public void checkoutBookShouldReturnTrueIfTheBookIsAvailableToBeChecked() throws NotFoundException {
        int bookId = 1;
        Book book = new Book(1, "Book 1", "Author 1", 1992);

        when(this.mockedBooksRepository.find(eq(bookId))).thenReturn(book);
        assertTrue(this.libraryController.checkoutBook(bookId));
    }

    @Test
    public void checkoutBookShouldReturnFalseIfTheBookIsNotAvailable() throws NotFoundException {
        int bookId = 1;
        Book book = new Book(1, "Book 1", "Author 1", 1992, true);

        when(this.mockedBooksRepository.find(eq(bookId))).thenReturn(book);
        assertFalse(this.libraryController.checkoutBook(bookId));
    }

    @Test
    public void checkoutBookShouldReturnFalseIfTheBookDoesNotExist() throws NotFoundException {
        int bookId = 2;

        when(this.mockedBooksRepository.find(eq(bookId))).thenThrow(NotFoundException.class);
        assertFalse(this.libraryController.checkoutBook(bookId));
    }

    @Test
    public void checkinBookShouldReturnABook() throws NotFoundException {
        int bookId = 3;
        Book book = new Book(3, "Book 3", "Author 3", 1992, true);

        when(this.mockedBooksRepository.find(eq(bookId))).thenReturn(book);
        this.libraryController.checkinBook(bookId);

        assertFalse(book.isChecked());
    }

    @Test
    public void checkinWithValidBookIdShouldReturnTrue() throws NotFoundException {
        int bookId = 3;
        Book book = new Book(3, "Book 3", "Author 3", 1992, true);

        when(this.mockedBooksRepository.find(eq(bookId))).thenReturn(book);
        assertTrue(this.libraryController.checkinBook(bookId));
    }

    @Test
    public void checkinWithAlreadyAvailableBookShouldReturnFalse() throws NotFoundException {
        int bookId = 3;
        Book book = new Book(3, "Book 3", "Author 3", 1992, false);

        when(this.mockedBooksRepository.find(eq(bookId))).thenReturn(book);
        assertFalse(this.libraryController.checkinBook(bookId));
    }

    @Test
    public void checkinWithInvalidBookIdShouldReturnFalse() throws NotFoundException {
        int bookId = 9;

        when(this.mockedBooksRepository.find(eq(bookId))).thenThrow(NotFoundException.class);
        assertFalse(this.libraryController.checkinBook(bookId));
    }
}
