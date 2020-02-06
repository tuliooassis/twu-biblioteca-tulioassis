package com.twu.biblioteca.item.repository;

import com.twu.biblioteca.item.exceptions.NotFoundException;
import com.twu.biblioteca.item.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repository<T extends Item> implements IRepository {
    List<T> items;

    public Repository(List<T> items) {
        this.items = items;
    }

    @Override
    public List<T> getAll() {
        return this.items;
    }

    @Override
    public List<T> getAvailableList() {
        return this.items.stream()
                .filter(b -> !b.isChecked())
                .collect(Collectors
                        .toCollection(ArrayList::new));
    }

    @Override
    public T find(int id) throws NotFoundException {
        return this.items.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElseThrow(() -> new NotFoundException());
    }
}
