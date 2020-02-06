package com.twu.biblioteca.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    List<T> getAvailableList();
    T find(int id) throws Exception;
}
