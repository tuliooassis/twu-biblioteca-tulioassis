package com.twu.biblioteca.item.model;

public interface IItem {
    void checkOut();
    void checkIn();
    boolean isChecked();
}
