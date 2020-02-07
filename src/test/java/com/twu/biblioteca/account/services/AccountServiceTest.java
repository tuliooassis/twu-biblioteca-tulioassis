package com.twu.biblioteca.account.services;

import com.twu.biblioteca.account.exceptions.WrongCredentialsException;
import com.twu.biblioteca.account.model.User;
import com.twu.biblioteca.account.repository.UserRepository;
import com.twu.biblioteca.item.exceptions.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
    @InjectMocks
    AccountService accountService;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() {
        this.accountService = new AccountService(this.userRepository);
    }

    @Test
    public void rightCredentialsShouldReturnTheAuthUser() throws NotFoundException, WrongCredentialsException {
        String number = "111-1111";
        String password = "pass";
        User userExpected = new User(number, password);

        Mockito.when(this.userRepository.find(Mockito.eq(number))).thenReturn(new User(number, password));

        User authUser = this.accountService.auth(number, password);

        assertEquals(userExpected, authUser);
    }

    @Test(expected = WrongCredentialsException.class)
    public void wrongPasswordShouldThrowWrongCredentialsException() throws NotFoundException, WrongCredentialsException {
        String number = "111-1111";
        String password = "pass";
        String wrongPassword = "pass10";

        Mockito.when(this.userRepository.find(Mockito.eq(number))).thenReturn(new User(number, password));

        this.accountService.auth(number, wrongPassword);
    }

    @Test(expected = WrongCredentialsException.class)
    public void wrongNumberShouldThrowWrongCredentialsException() throws NotFoundException, WrongCredentialsException {
        String wrongNumber = "112-1111";
        String password = "pass";

        Mockito.when(this.userRepository.find(Mockito.eq(wrongNumber))).thenThrow(NotFoundException.class);

        this.accountService.auth(wrongNumber, password);
    }
}