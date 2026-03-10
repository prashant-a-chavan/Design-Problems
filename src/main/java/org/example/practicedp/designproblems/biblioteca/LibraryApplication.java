package org.example.practicedp.designproblems.biblioteca;

import org.example.practicedp.designproblems.biblioteca.actions.*;

import java.util.Map;
import java.util.TreeMap;

public class LibraryApplication {
    private final Library library;

    public LibraryApplication() {
        this.library = new Library();
    }

    public void start() {
        System.out.println("Welcome to Bangalore Public Library!");

        Menu menu = getMenu();

        while (true) {
            int choice = menu.showAndGetChoice();
            if (choice == 0) {
                System.out.println("Thanks!");
                break;
            }

            if (!menu.isValid(choice)) {
                System.out.println("Invalid input!");
                break;
            }

            menu.handleChoiceAndExecute(choice, library);
        }
    }

    private Menu getMenu() {
        MenuAction listBooksAction = new ListBooksAction();
        MenuAction checkoutBookAction = new CheckoutBookAction();
        MenuAction returnBookAction = new ReturnBookAction();
        MenuAction dummyAction = new DummyAction();

        Map<Integer, MenuAction> menuActions = new TreeMap<>();
        menuActions.put(1, listBooksAction);
        menuActions.put(2, checkoutBookAction);
        menuActions.put(3, returnBookAction);
        menuActions.put(4, dummyAction);

        return new Menu(menuActions);
    }
}
