package com.twu.biblioteca.model;

import java.util.Objects;

public class Item implements IItem {
    private int id;
    private boolean checked;

    public Item(int id){
        this.id = id;
        this.checked = false;
    }

    public Item(int id, boolean checked){
        this.id = id;
        this.checked = checked;
    }

    public int getId() {
        return this.id;
    }
    public void checkOut() {
        this.checked = true;
    }
    public void checkIn() {
        this.checked = false;
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
