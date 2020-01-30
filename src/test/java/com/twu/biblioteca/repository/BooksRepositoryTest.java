package com.twu.biblioteca.repository;

import com.twu.biblioteca.exceptions.NotFoundException;
import com.twu.biblioteca.model.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooksRepositoryTest {
    BooksRepository booksRepository = new BooksRepository();

    @Test
    public void bookListShouldHas3Books() {
        int count = 3;
        assertEquals(count, booksRepository.getAll().size());
    }

    @Test
    public void bookAvailableListShouldHas2Books() {
        int count = 2;
        assertEquals(count, booksRepository.getAvailableList().size());
    }

    @Test
    public void bookShouldBeRecoveredById() throws NotFoundException {
        Book book = new Book(2,"Book 2", "Author 1", 2000);
        Book bookRecovered = this.booksRepository.find(2);
        assertEquals(book, bookRecovered);
    }

    @Test(expected = NotFoundException.class)
    public void getBookIdShouldThrowABookNotFoundExceptionIfTheBookDoesNotExists() throws NotFoundException {
        this.booksRepository.find(9);
    }
}