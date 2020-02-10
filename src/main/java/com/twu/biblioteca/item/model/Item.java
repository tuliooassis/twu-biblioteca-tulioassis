package com.twu.biblioteca.item.model;

import com.twu.biblioteca.account.model.User;

import java.util.Objects;

public class Item implements IItem {
    private int id;
    private boolean checked;
    private User userChecked;

    public Item(int id){
        this.id = id;
        this.checked = false;
    }

    public int getId() {
        return this.id;
    }
    public void checkOut(User user) {
        this.userChecked = user;
        this.checked = true;
    }
    public void checkIn() {
        this.userChecked = null;
        this.checked = false;
    }

    public String getUserNumber() {
        return this.userChecked.getLibraryNumber();
    }

    public boolean isChecked() {
        return this.checked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                checked == item.checked;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checked);
    }
}
