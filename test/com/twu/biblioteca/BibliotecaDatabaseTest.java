package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaDatabaseTest {
    BibliotecaDatabase bibliotecaDatabase = new BibliotecaDatabase();

    @Test
    public void bookListShouldHas3Books() {
        int count = 3;
        assertEquals(count, bibliotecaDatabase.getBooks().size());
    }
}