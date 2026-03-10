package org.example.practicedp.designproblems.biblioteca.actions;

import org.example.practicedp.designproblems.biblioteca.Book;
import org.example.practicedp.designproblems.biblioteca.Library;

import java.util.List;

import static org.example.practicedp.designproblems.biblioteca.utils.Utils.printWithNewLine;

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
