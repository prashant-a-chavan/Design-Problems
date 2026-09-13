package practicedp.designproblems.biblioteca.actions;

import practicedp.designproblems.biblioteca.Library;

public interface MenuAction {
    void execute(Library library);
    String getLabel();
}
