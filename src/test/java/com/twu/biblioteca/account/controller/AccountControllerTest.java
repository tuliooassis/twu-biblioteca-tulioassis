package com.twu.biblioteca.account.controller;

import com.twu.biblioteca.account.exceptions.WrongCredentialsException;
import com.twu.biblioteca.account.model.User;
import com.twu.biblioteca.account.services.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {
    @InjectMocks
    AccountController accountController;

    @Mock
    AccountService accountService;

    @Before
    public void setUp() {
        this.accountController = new AccountController(this.accountService);
    }

    @Test
    public void loginShouldReturnTrueIfLogged() throws WrongCredentialsException {
        String number = "111-1111";
        String password = "pass";

        Mockito.when(this.accountService.auth(Mockito.eq(number), Mockito.eq(password))).thenReturn(new User(number, password));

        boolean isLogged = this.accountController.login(number, password);

        assertTrue(isLogged);
    }

    @Test
    public void loginShouldReturnFalseIfNotLogged() throws WrongCredentialsException {
        String number = "111-1111";
        String password = "pass";

        Mockito.when(this.accountService.auth(Mockito.eq(number), Mockito.eq(password))).thenThrow(WrongCredentialsException.class);

        boolean isLogged = this.accountController.login(number, password);

        assertFalse(isLogged);
    }

    @Test
    public void afterLoginUserShouldBePossibleToRecovery() throws WrongCredentialsException {
        String number = "111-1111";
        String password = "pass";
        User user = new User(number, password);

        Mockito.when(this.accountService.auth(Mockito.eq(number), Mockito.eq(password))).thenReturn(new User(number, password));
        this.accountController.login(number, password);

        User loggedUser = this.accountController.getLoggedUser();

        assertEquals(user, loggedUser);
    }

    @Test
    public void logoutShouldSetUserAsNull() {
        this.accountController.logout();

        User loggedUser = this.accountController.getLoggedUser();

        assertEquals(null, loggedUser);
    }
}