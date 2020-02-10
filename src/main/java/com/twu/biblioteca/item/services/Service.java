package com.twu.biblioteca.item.services;

import com.twu.biblioteca.account.controller.AccountController;
import com.twu.biblioteca.item.exceptions.NotFoundException;
import com.twu.biblioteca.item.model.Item;
import com.twu.biblioteca.item.repository.Repository;

import java.util.List;

public class Service<T extends Item> implements IService{
    private Repository<T> repository;
    private AccountController accountController;

    public Service(Repository<T> repository, AccountController accountController) {
        this.repository = repository;
        this.accountController = accountController;
    }

    @Override
    public List<T> getItems() {
        return repository.getAll();
    }

    @Override
    public boolean checkOut(int id) {
        try {
            T item = this.repository.find(id);

            if(!item.isChecked()){
                item.checkOut(this.accountController.getLoggedUser());
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
