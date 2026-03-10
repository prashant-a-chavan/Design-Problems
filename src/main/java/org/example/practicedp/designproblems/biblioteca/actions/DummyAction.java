package org.example.practicedp.designproblems.biblioteca.actions;

import org.example.practicedp.designproblems.biblioteca.Library;

public class DummyAction implements MenuAction {

    @Override
    public void execute(Library library) {
        System.out.println("Dummy execute method");
    }

    @Override
    public String getLabel() {
        return "Dummy Label";
    }
}
