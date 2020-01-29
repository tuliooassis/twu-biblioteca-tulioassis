package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooksRepositoryTest {
    BooksRepository booksRepository = new BooksRepository();

    @Test
    public void bookListShouldHas3Books() {
        int count = 3;
        assertEquals(count, booksRepository.getBooks().size());
    }

    @Test
    public void bookAvailableListShouldHas2Books() {
        int count = 2;
        assertEquals(count, booksRepository.getAvailableBooks().size());
    }

    @Test
    public void bookShouldBeRecoveredById() {
        Book book = new Book(2,"Book 2", "Author 1", 2000);
        Book bookRecovered = this.booksRepository.getBookById(2);
        assertEquals(book, bookRecovered);
    }
}