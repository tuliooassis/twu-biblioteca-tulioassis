package com.twu.biblioteca.repository;

import java.util.ArrayList;

public interface IRepository<T> {
    ArrayList<T> getAll();
    ArrayList<T> getAvailableList();
    T find(int id) throws Exception;
}
