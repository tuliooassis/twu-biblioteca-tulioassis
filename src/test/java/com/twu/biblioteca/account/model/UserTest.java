package com.twu.biblioteca.account.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User user;

    String number;
    String password;

    @Before
    public void setUp() {
        this.number = "111-1111";
        this.password = "pass";
        this.user = new User(this.number, this.password);
    }

    @Test
    public void passwordCheckerShouldReturnTrueWhenItIsCorrect() {
        boolean result = this.user.passwordChecker(this.password);

        assertTrue(result);
    }

    @Test
    public void passwordCheckerShouldReturnFalseWhenItIsNotCorrect() {
        String wrongPassword = this.password + "01";

        boolean result = this.user.passwordChecker(wrongPassword);

        assertFalse(result);
    }

}