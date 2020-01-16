package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    Book book = new Book("Book", "Author", 2020);

    @Test
    public void bookStringShouldBeCorrect() {
        String bookString = "Book:\tBook\tAuthor:\tAuthor\tPublished at:\t2020";
        assertEquals(book.toString(), bookString);
    }
}