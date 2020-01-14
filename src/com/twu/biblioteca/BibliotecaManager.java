package com.twu.biblioteca;

public class BibliotecaManager {
    private String welcomeMessage;

    public BibliotecaManager() {
        this.welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String getWelcomeMessage() {
        return this.welcomeMessage;
    }
}
