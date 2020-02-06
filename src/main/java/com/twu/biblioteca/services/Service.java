package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.NotFoundException;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.repository.Repository;

import java.util.List;

public class Service<T extends Item> implements IService{
    private Repository<T> repository;

    public Service(Repository<T> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> getItems() {
        return repository.getAvailableList();
    }

    @Override
    public boolean checkOut(int id) {
        try {
            T item = this.repository.find(id);

            if(!item.isChecked()){
                item.checkOut();
                return true;
            }
            return false;
        }
        catch (NotFoundException ex) {
            return false;
        }
    }

    @Override
    public boolean checkIn(int id) {
        try {
            T item = this.repository.find(id);

            if(item.isChecked()){
                item.checkIn();
                return true;
            }
            return false;
        }
        catch (NotFoundException ex) {
            return false;
        }
    }
}
