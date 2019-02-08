package com.twu.biblioteca;

public class QuitMenu implements SelectableMenu {

    @Override
    public void execute(BibliotecaApp app, String ...params) {
        System.out.println("Bye!");
        System.exit(0);
    }
}
