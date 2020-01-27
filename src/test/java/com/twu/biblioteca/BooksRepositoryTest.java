package com.twu.biblioteca;

import com.twu.biblioteca.repository.BooksRepository;
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
    public void bookShouldBeChecked() {
        int bookId = 2;
    }
}