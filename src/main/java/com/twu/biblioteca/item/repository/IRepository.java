package com.twu.biblioteca.item.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    List<T> getAvailableList();
    T find(int id) throws Exception;
}
