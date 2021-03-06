package com.twu.biblioteca.item.controller;

import com.twu.biblioteca.item.model.Item;
import com.twu.biblioteca.item.services.Service;

import java.util.ArrayList;

public class ItemController<T extends Item> {
    Service<T> service;

    public ItemController(Service service) {
        this.service = service;
    }

    public String getString() {
        String itemsString = "";
        ArrayList<T> items = new ArrayList<>(this.service.getItems());

        for (T item : items) {
            itemsString += item.toString() + "\n";
        }

        return itemsString;
    }

    public boolean checkOut(int id){
        return this.service.checkOut(id);
    }

    public boolean checkIn(int id) {
        return this.service.checkIn(id);
    }
}