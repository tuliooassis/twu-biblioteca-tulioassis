package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.services.Service;

import java.util.ArrayList;

public class BookController {
    Service<Book> service;

    public BookController(Service bookService) {
        this.service = bookService;
    }

    public String getString() {
        String booksString = "";
        ArrayList<Book> books = new ArrayList<>(this.service.getItems());

        for (Book book : books) {
            booksString += book.toString() + "\n";
        }

        return booksString;
    }

    public boolean checkOut(int id){
        return this.service.checkOut(id);
    }

    public boolean checkIn(int id) {
        return this.service.checkIn(id);
    }
}
