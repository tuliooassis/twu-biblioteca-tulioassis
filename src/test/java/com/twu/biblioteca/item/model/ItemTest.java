package com.twu.biblioteca.item.model;

import com.twu.biblioteca.account.model.User;
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
        User user = new User("111-1111", "pass");
        this.item.checkOut(user);

        boolean isChecked = this.item.isChecked();

        assertTrue(isChecked);
    }

    @Test
    public void bookShouldBeReturned() {
        this.item.checkIn();

        boolean isChecked = this.item.isChecked();

        assertFalse(isChecked);
    }

    @Test
    public void userCheckedShouldBeUpdatedWhenCheckOut() {
        User user = new User("111-1111", "pass");

        this.item.checkOut(user);

        assertEquals("111-1111", this.item.getUserNumber());
    }

    @Test(expected = NullPointerException.class)
    public void userCheckedShouldBeNullWhenCheckIn() {
        User user = new User("111-1111", "pass");

        this.item.checkOut(user);

        this.item.checkIn();

        assertEquals(null, this.item.getUserNumber());
    }
}