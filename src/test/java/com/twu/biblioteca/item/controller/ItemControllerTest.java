package com.twu.biblioteca.item.controller;

import com.twu.biblioteca.item.model.Item;
import com.twu.biblioteca.item.services.Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
    @InjectMocks
    ItemController<Item> itemController;

    @Mock
    Service<Item> service;

    int id;

    @Before
    public void setUp(){
        this.id = 0;
        this.itemController = new ItemController<>(this.service);
    }

    @Test
    public void checkOutShouldCallServiceCheckOut() {
        this.itemController.checkOut(this.id);

        Mockito.verify(this.service, Mockito.times(1)).checkOut(Mockito.eq(this.id));
    }

    @Test
    public void checkInShouldCallServiceCheckIn() {
        this.itemController.checkIn(this.id);

        Mockito.verify(this.service, Mockito.times(1)).checkIn(Mockito.eq(this.id));
    }

    @Test
    public void getStringShouldCallServiceGetItems() {
        this.itemController.getString();

        Mockito.verify(this.service, Mockito.times(1)).getItems();
    }
}
