package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;

public interface SelectableMenu {

    void execute(BibliotecaApp context, String ...args);
}
