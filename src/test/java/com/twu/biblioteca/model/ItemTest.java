package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    Item item;
    int id;

    @Before
    public void setUp() {
        this.id = 1;
        this.item = new Item(this.id);
    }

    @Test
    public void itemShouldHasAId() {
        int id = this.item.getId();

        assertEquals(this.id, id);
    }

    @Test
    public void bookShouldInitWithCheckedFalse() {
        boolean isChecked = this.item.isChecked();

        assertFalse(isChecked);
    }

    @Test
    public void bookShouldBeChecked() {
        this.item.checkOut();

        boolean isChecked = this.item.isChecked();

        assertTrue(isChecked);
    }

    @Test
    public void bookShouldBeReturned() {
        this.item.checkIn();

        boolean isChecked = this.item.isChecked();

        assertFalse(isChecked);
    }
}