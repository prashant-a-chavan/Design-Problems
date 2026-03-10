package org.example.practicedp.designproblems.biblioteca;

import org.example.practicedp.designproblems.biblioteca.actions.MenuAction;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Map<Integer, MenuAction> menuActions;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(Map<Integer, MenuAction> menuActions) {
        this.menuActions = menuActions;
    }

    public int showAndGetChoice() {
        System.out.println("\nChoose an option: ");
        menuActions.forEach((key, value) -> System.out.println(key + " : " + value.getLabel()));

        System.out.println("0 : Quit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public boolean isValid(int choice) {
        return choice == 0 || menuActions.containsKey(choice);
    }

    public void handleChoiceAndExecute(int choice, Library library) {
        menuActions.get(choice).execute(library);
    }
}
