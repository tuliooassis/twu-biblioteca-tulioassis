package com.twu.biblioteca;

import com.twu.biblioteca.model.BookModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookModelTest {
    BookModel bookModel = new BookModel("Book", "Author", 2020);

    @Test
    public void bookStringShouldBeCorrect() {
        String bookString = "Book:\tBook\tAuthor:\tAuthor\tPublished at:\t2020";
        assertEquals(bookModel.toString(), bookString);
    }
}