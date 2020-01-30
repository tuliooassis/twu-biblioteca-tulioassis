package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BookTest {
    Book book;

    @Before
    public void setup() {
        this.book = new Book(1,"Book", "Author", 2020);
    }

    @Test
    public void bookStringShouldBeCorrect() {
        String bookString = "(1) Book:\tBook\tAuthor:\tAuthor\tPublished at:\t2020";
        assertEquals(this.book.toString(), bookString);
    }

    @Test
    public void bookShouldInitWithCheckedFalse() {
        assertFalse(this.book.isChecked());
    }

    @Test
    public void bookShouldBeChecked() {
        this.book.checkout();
        assertTrue(this.book.isChecked());
    }

    @Test
    public void bookShouldBeReturned() {
        this.book.checkin();
        assertFalse(this.book.isChecked());
    }
}