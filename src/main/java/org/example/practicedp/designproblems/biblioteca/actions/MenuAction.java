package org.example.practicedp.designproblems.biblioteca.actions;

import org.example.practicedp.designproblems.biblioteca.Library;

public interface MenuAction {
    void execute(Library library);
    String getLabel();
}
