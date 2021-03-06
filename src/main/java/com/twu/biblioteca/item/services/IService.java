package com.twu.biblioteca.item.services;

import java.util.List;

public interface IService<T> {
    List<T> getItems();
    boolean checkOut(int id);
    boolean checkIn(int id);
}
