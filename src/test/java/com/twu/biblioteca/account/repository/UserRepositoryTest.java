package com.twu.biblioteca.account.repository;

import com.twu.biblioteca.account.model.User;
import com.twu.biblioteca.item.exceptions.NotFoundException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserRepositoryTest {
    UserRepository userRepository;


    @Before
    public void setUp() {
        this.userRepository = new UserRepository();
    }

    @Test
    public void userShouldBeFoundByLibraryNumber() throws NotFoundException {
        String number = "111-1111";
        String password = "pass";
        User userExpected = new User(number, password);

        User userAtual = this.userRepository.find(number);

        assertEquals(userExpected, userAtual);
    }
}