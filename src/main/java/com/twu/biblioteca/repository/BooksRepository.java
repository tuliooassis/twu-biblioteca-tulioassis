package com.twu.biblioteca.repository;

import com.twu.biblioteca.exceptions.NotFoundException;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BooksRepository implements IRepository {
    private ArrayList<Book> books;

    public BooksRepository() {
        this.books = new ArrayList<Book>();

        this.books.add(new Book(1,"Book 1", "Author 1", 1997));
        this.books.add(new Book(3, "Book 3", "Author 2", 2012, true));
        this.books.add(new Book(2,"Book 2", "Author 1", 2000));
    }

    @Override
    public ArrayList getAll() {
        return this.books;
    }

    @Override
    public ArrayList getAvailableList() {
        return this.books.stream()
                .filter(b -> !b.isChecked())
                .collect(Collectors
                .toCollection(ArrayList::new));
    }

    @Override
    public Book find(int id) throws NotFoundException {
        return this.books.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElseThrow(() -> new NotFoundException());
    }
}
