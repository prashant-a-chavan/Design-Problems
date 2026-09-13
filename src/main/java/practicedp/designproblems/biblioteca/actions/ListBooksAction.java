package practicedp.designproblems.biblioteca.actions;

import practicedp.designproblems.biblioteca.Book;
import practicedp.designproblems.biblioteca.Library;

import java.util.List;

import static practicedp.designproblems.biblioteca.utils.Utils.printWithNewLine;

public class ListBooksAction implements MenuAction {

    @Override
    public void execute(Library library) {
        library.getAvailableBooks().forEach(book -> printWithNewLine(book.toString()));
    }

    @Override
    public String getLabel() {
        return "List Books";
    }
}
