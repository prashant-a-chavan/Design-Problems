package practicedp.designproblems.biblioteca.actions;

import practicedp.designproblems.biblioteca.Library;

import static practicedp.designproblems.biblioteca.utils.Utils.printWithNewLine;
import static practicedp.designproblems.biblioteca.utils.Utils.readLine;

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