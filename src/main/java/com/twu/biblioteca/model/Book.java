package com.twu.biblioteca.model;

import java.util.Objects;

public class Book implements ILibraryItem{
    private int id;
    private String name;
    private String author;
    private int publishedYear;
    private boolean checked;

    public Book(int id, String name, String author, int publishedYear) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.checked = false;
    }

    public Book(int id, String name, String author, int publishedYear, boolean checked) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.checked = checked;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void checkout() {
        this.checked = true;
    }

    @Override
    public void checkin() {
        this.checked = false;
    }

    @Override
    public boolean isChecked() {
        return this.checked;
    }

    @Override
    public String toString() {
        return "(" + this.id + ") Book:\t" + this.name +
                "\tAuthor:\t" + this.author +
                "\tPublished at:\t" + this.publishedYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                publishedYear == book.publishedYear &&
                checked == book.checked &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author);
    }
}