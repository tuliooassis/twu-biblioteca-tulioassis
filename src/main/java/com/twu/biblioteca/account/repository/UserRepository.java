package com.twu.biblioteca.account.repository;

import com.twu.biblioteca.account.model.User;
import com.twu.biblioteca.item.exceptions.NotFoundException;

import java.util.ArrayList;

public class UserRepository {
    ArrayList<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        this.users.add(new User("111-1111", "pass"));
        this.users.add(new User("222-1111", "word"));
        this.users.add(new User("333-1111", "password"));
    }

    public User find(String libraryNumber) throws NotFoundException {
        return this.users.stream()
                .filter(u -> u.getLibraryNumber().equals(libraryNumber))
                .findAny()
                .orElseThrow(() -> new NotFoundException());
    }
}
