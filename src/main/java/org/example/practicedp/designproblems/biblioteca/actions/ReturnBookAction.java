package org.example.practicedp.designproblems.biblioteca.actions;

import org.example.practicedp.designproblems.biblioteca.Library;

import static org.example.practicedp.designproblems.biblioteca.utils.Utils.printWithNewLine;
import static org.example.practicedp.designproblems.biblioteca.utils.Utils.readLine;

public class ReturnBookAction implements MenuAction {

    @Override
    public void execute(Library library) {
        printWithNewLine("Enter Title to return: ");
        String enteredBook = readLine();

        String returnedMessage = library.returnBook(enteredBook);
        printWithNewLine(returnedMessage);
    }

    @Override
    public String getLabel() {
        return "Return Book";
    }
}


// library.return(book)
// libaray.has?(book)