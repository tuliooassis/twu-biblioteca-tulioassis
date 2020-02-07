package com.twu.biblioteca.account.services;

import com.twu.biblioteca.account.exceptions.WrongCredentialsException;
import com.twu.biblioteca.account.model.User;
import com.twu.biblioteca.account.repository.UserRepository;
import com.twu.biblioteca.item.exceptions.NotFoundException;

public class AccountService {
    UserRepository userRepository;

    public AccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User auth(String number, String password) throws WrongCredentialsException {
        try {
            User user = this.userRepository.find(number);
            boolean isPasswordValid = user.passwordChecker(password);

            if (isPasswordValid)
                return user;
            else
                throw new WrongCredentialsException();
        } catch (NotFoundException ex) {
            throw new WrongCredentialsException();
        }
    }
}
