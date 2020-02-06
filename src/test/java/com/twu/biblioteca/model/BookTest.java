package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    Book book;

    @Before
    public void setup() {
        this.book = new Book(1,"Book", "Author", 2020);
    }

    @Test
    public void bookStringShouldBeCorrect() {
        String bookStringExpected = "(1) Book:\tBook\tAuthor:\tAuthor\tPublished at:\t2020";

        String bookStringAtual = this.book.toString();

        assertEquals(bookStringExpected, bookStringAtual);
    }
}