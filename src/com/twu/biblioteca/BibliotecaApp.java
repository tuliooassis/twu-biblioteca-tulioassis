package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaManager bibliotecaManager = new BibliotecaManager();

        System.out.println(bibliotecaManager.getWelcomeMessage());

        System.out.println("-- Library Books --");
        System.out.print(bibliotecaManager.getBooksString());
    }
}
