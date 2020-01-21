package com.twu.biblioteca.model;

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

    public void checkout() {
        this.checked = true;
    }

    public boolean isChecked() {
        return this.checked;
    }

    @Override
    public String toString() {
        return "(" + this.id + ") Book:\t" + this.name +
                "\tAuthor:\t" + this.author +
                "\tPublished at:\t" + this.publishedYear;
    }
}