package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;

import java.util.Scanner;

public class LogInMenu extends Menu {

    @Override
    public void execute(BibliotecaApp context, String... args) {

        Scanner scanner = context.getScanner();

        String libraryNumber = promptUserLibraryNumber(scanner);
        String password = promptUserPassword(scanner);

        context.login(libraryNumber, password);
    }

    public String promptUserLibraryNumber(Scanner scanner){
        System.out.println("Please enter your library number and password");

        System.out.print("Library Number: ");

        return scanner.nextLine();
    }

    public String promptUserPassword(Scanner scanner){
        System.out.print("Password:");

        return scanner.nextLine();
    }
}
