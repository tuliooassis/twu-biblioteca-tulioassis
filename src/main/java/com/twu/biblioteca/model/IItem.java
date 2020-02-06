package com.twu.biblioteca.model;

public interface IItem {
    void checkOut();
    void checkIn();
    boolean isChecked();
}
