package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaManagerTest {
    BibliotecaManager bibliotecaManager = new BibliotecaManager();

    @Test
    public void welcomeMessageShouldBeCorrect() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        assertEquals(welcomeMessage, bibliotecaManager.getWelcomeMessage());
    }

    @Test
    public void booksStringsShouldBeLikeThePattern() {
        String booksString = "Book:\tBook 1\n" +
                "Book:\tBook 2\n" +
                "Book:\tBook 3\n";

        assertEquals(booksString, bibliotecaManager.getBooksString());
    }
}
