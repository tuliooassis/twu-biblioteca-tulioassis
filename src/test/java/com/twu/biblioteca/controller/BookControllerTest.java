package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.services.Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {
    @InjectMocks
    BookController bookController;

    @Mock
    Service<Item> service;

    int id;

    @Before
    public void setUp(){
        this.id = 0;
        this.bookController = new BookController(this.service);
    }

    @Test
    public void checkOutShouldCallServiceCheckOut() {
        this.bookController.checkOut(this.id);

        Mockito.verify(this.service, Mockito.times(1)).checkOut(Mockito.eq(this.id));
    }

    @Test
    public void checkInShouldCallServiceCheckIn() {
        this.bookController.checkIn(this.id);

        Mockito.verify(this.service, Mockito.times(1)).checkIn(Mockito.eq(this.id));
    }

    @Test
    public void getStringShouldCallServiceGetItems() {
        this.bookController.getString();

        Mockito.verify(this.service, Mockito.times(1)).getItems();
    }
}
