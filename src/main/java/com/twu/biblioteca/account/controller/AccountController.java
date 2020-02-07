package com.twu.biblioteca.account.controller;

import com.twu.biblioteca.account.exceptions.WrongCredentialsException;
import com.twu.biblioteca.account.model.User;
import com.twu.biblioteca.account.services.AccountService;

public class AccountController {
    AccountService accountService;
    User loggedUser;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public boolean login(String number, String password) {
        try {
            this.loggedUser = this.accountService.auth(number, password);
            return true;

        } catch (WrongCredentialsException ex) {
            return false;
        }
    }

    public User getLoggedUser(){
        return loggedUser;
    }
}
