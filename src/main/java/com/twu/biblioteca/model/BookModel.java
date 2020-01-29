package com.twu.biblioteca.model;

import java.util.Objects;

public class BookModel {
    private int id;
    private String name;
    private String author;
    private int publishedYear;
    private boolean checked;

    public BookModel(int id, String name, String author, int publishedYear) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.checked = false;
    }

    public BookModel(int id, String name, String author, int publishedYear, boolean checked) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.checked = checked;
    }

    public void checkout() {
        this.checked = true;
    }

    public void checkin() {
        this.checked = false;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public int getId() {
        return this.id;
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
        BookModel bookModel = (BookModel) o;
        return id == bookModel.id &&
                publishedYear == bookModel.publishedYear &&
                checked == bookModel.checked &&
                Objects.equals(name, bookModel.name) &&
                Objects.equals(author, bookModel.author);
    }
}