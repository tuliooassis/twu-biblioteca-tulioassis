package com.twu.biblioteca.model;

public interface ILibraryItem {
    void checkout();
    void checkin();
    boolean isChecked();
}
