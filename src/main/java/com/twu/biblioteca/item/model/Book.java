package com.twu.biblioteca.item.model;

import java.util.Objects;

public class Book extends Item {
    private String name;
    private String author;
    private int publishedYear;

    public Book(int id, String name, String author, int publishedYear) {
        super(id);
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        String details = "(" + this.getId() + ") Book:\t" + this.name +
                "\tAuthor:\t" + this.author +
                "\tPublished at:\t" + this.publishedYear;

        if (super.isChecked()) {
            details += "\tChecked by:\t" + super.getUserNumber();
        }

        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return publishedYear == book.publishedYear &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, author, publishedYear);
    }
}