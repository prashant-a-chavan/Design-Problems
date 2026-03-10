package org.example.practicedp.designproblems.biblioteca.actions;

import org.example.practicedp.designproblems.biblioteca.Library;

import static org.example.practicedp.designproblems.biblioteca.utils.Utils.printWithNewLine;
import static org.example.practicedp.designproblems.biblioteca.utils.Utils.readLine;

public class CheckoutBookAction implements MenuAction {

    @Override
    public void execute(Library library) {
        printWithNewLine("Enter Title to checkout: ");
        String enteredBook = readLine();

        String returnedMessage = library.checkout(enteredBook);
        printWithNewLine(returnedMessage);
    }

    @Override
    public String getLabel() {
        return "Checkout Book";
    }
}