package com.twu.biblioteca;

import com.twu.biblioteca.model.BookModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookModelTest {
    BookModel bookModel;

    @Before
    public void setup() {
        this.bookModel = new BookModel(1,"Book", "Author", 2020);
    }

    @Test
    public void bookStringShouldBeCorrect() {
        String bookString = "(1) Book:\tBook\tAuthor:\tAuthor\tPublished at:\t2020";
        assertEquals(this.bookModel.toString(), bookString);
    }

    @Test
    public void bookShouldInitWithCheckedFalse() {
        assertFalse(this.bookModel.isChecked());
    }

    @Test
    public void bookShouldBeChecked() {
        this.bookModel.checkout();
        assertTrue(this.bookModel.isChecked());
    }
}