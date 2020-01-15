package com.twu.biblioteca;

import java.util.Date;

public class Book {
    private String name;
    private String author;
    private int publishedYear;

    public Book(String name, String author, int publishedYear) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Book:\t" + this.name +
                "\tAuthor:\t" + this.author +
                "\tPublished at:\t" + this.publishedYear;
    }
}