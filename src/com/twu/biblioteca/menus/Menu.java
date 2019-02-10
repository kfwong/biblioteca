package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;

public interface Menu {

    void execute(BibliotecaApp context, String ...args);
}
