package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;

public class QuitMenu extends Menu {

    @Override
    public void execute(BibliotecaApp app, String ...params) {
        System.out.println("Bye!");
        System.exit(0);
    }
}
