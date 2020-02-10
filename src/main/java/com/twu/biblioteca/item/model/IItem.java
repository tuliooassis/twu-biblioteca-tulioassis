package com.twu.biblioteca.item.model;

import com.twu.biblioteca.account.model.User;

public interface IItem {
    void checkOut(User user);
    void checkIn();
    boolean isChecked();
}
