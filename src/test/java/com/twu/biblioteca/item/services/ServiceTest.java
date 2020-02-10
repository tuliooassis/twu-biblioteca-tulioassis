package com.twu.biblioteca.item.services;

import com.twu.biblioteca.account.controller.AccountController;
import com.twu.biblioteca.account.model.User;
import com.twu.biblioteca.item.exceptions.NotFoundException;
import com.twu.biblioteca.item.model.Item;
import com.twu.biblioteca.item.repository.Repository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
    @InjectMocks
    Service<Item> service;

    @Mock
    Repository<Item> repository;

    @Mock
    AccountController accountController;

    Item item;
    int id;

    @Before
    public void setUp() {
        this.service = new Service<>(this.repository, this.accountController);
        this.id = 0;
        this.item = new Item(this.id);
    }

    @Test
    public void getItemsShouldGetAvailableList() {
        this.service.getItems();

        Mockito.verify(this.repository, Mockito.times(1)).getAll();
    }

    @Test
    public void checkOutShouldReturnTrueWhenSuccess() throws NotFoundException {
        Mockito.when(this.repository.find(Mockito.eq(this.id))).thenReturn(new Item(this.id));

        boolean result = this.service.checkOut(this.id);

        assertTrue(result);
    }

    @Test
    public void checkOutShouldReturnFalseWhenItemIsAlreadyChecked() throws NotFoundException {
        this.item.checkOut(new User("111-1111", "pass"));
        Mockito.when(this.repository.find(Mockito.eq(this.id))).thenReturn(this.item);

        boolean result = this.service.checkOut(this.id);

        assertFalse(result);
    }

    @Test
    public void checkOutShouldReturnFalseWhenFindThrowsAException() throws NotFoundException {
        Mockito.when(this.repository.find(Mockito.eq(this.id))).thenThrow(NotFoundException.class);

        boolean result = this.service.checkOut(this.id);

        assertFalse(result);
    }

    @Test
    public void checkInShouldReturnTrueWhenSuccess() throws NotFoundException {
        this.item.checkOut(new User("111-1111", "pass"));
        Mockito.when(this.repository.find(Mockito.eq(this.id))).thenReturn(this.item);

        boolean result = this.service.checkIn(this.id);

        assertTrue(result);
    }

    @Test
    public void checkInShouldReturnFalseWhenItemIsNotChecked() throws NotFoundException {
        Mockito.when(this.repository.find(Mockito.eq(this.id))).thenReturn(this.item);

        boolean result = this.service.checkIn(this.id);

        assertFalse(result);
    }

    @Test
    public void checkInShouldReturnFalseWhenFindThrowsAException() throws NotFoundException {
        Mockito.when(this.repository.find(Mockito.eq(this.id))).thenThrow(NotFoundException.class);

        boolean result = this.service.checkIn(this.id);

        assertFalse(result);
    }
}