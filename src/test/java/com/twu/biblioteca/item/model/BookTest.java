package com.twu.biblioteca.item.model;

import com.twu.biblioteca.account.model.User;
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

    @Test
    public void checkedBookStringShouldHasWhoCheckedThisBook() {
        String bookStringExpected = "(1) Book:\tBook\tAuthor:\tAuthor\tPublished at:\t2020\tChecked by:\t111-1111";

        this.book.checkOut(new User("111-1111", "pass"));
        String bookStringAtual = this.book.toString();

        assertEquals(bookStringExpected, bookStringAtual);
    }
}