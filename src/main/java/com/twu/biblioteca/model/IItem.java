package com.twu.biblioteca.model;

public interface IItem {
    void checkout();
    void checkin();
    boolean isChecked();
}
