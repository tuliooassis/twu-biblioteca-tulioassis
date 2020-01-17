package com.twu.biblioteca;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.repository.BooksRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryControllerTest {
    // Todo: mock
    BooksRepository booksRepository = new BooksRepository();
    LibraryController libraryController = new LibraryController(booksRepository);

    @Test
    public void welcomeMessageShouldBeCorrect() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        assertEquals(welcomeMessage, libraryController.getWelcomeMessage());
    }

    @Test
    public void booksStringsShouldBeLikeThePattern() {
        String booksString = "Book:\tBook 1\tAuthor:\tAuthor 1\tPublished at:\t1997\n" +
                "Book:\tBook 2\tAuthor:\tAuthor 1\tPublished at:\t2000\n" +
                "Book:\tBook 3\tAuthor:\tAuthor 2\tPublished at:\t2012\n";

        assertEquals(booksString, libraryController.getBooksString());
    }
}
