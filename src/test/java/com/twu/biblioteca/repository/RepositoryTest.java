package com.twu.biblioteca.repository;

import com.twu.biblioteca.exceptions.NotFoundException;
import com.twu.biblioteca.model.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RepositoryTest {
    Repository<Item> repository;

    @Before
    public void setUp() {
        List<Item> items = new ArrayList<>();

        items.add(new Item(1));
        items.add(new Item(2, true));
        items.add(new Item(3));

        this.repository = new Repository<>(items);
    }

    @Test
    public void shouldHas3Items() {
        int count = 3;

        List<Item> items = repository.getAll();

        assertEquals(count, items.size());
    }

    @Test
    public void availableListShouldHas2Books() {
        int count = 2;

        List<Item> availableItems = repository.getAvailableList();

        assertEquals(count, availableItems.size());
    }

    @Test
    public void shouldBeRecoveredById() throws NotFoundException {
        int id = 1;
        Item item = new Item(id);

        Item itemRecovered = this.repository.find(id);

        assertEquals(item, itemRecovered);
    }

    @Test(expected = NotFoundException.class)
    public void findItemShouldThrowANotFoundExceptionIfTheItemDoesNotExists() throws NotFoundException {
        this.repository.find(9);
    }
}