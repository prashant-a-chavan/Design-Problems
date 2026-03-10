package org.example.practicedp.designproblems.biblioteca.utils;

import java.util.Scanner;
import java.util.logging.Logger;

public final class Utils {
    private Utils() {
    }

    private static final Scanner sc = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(Utils.class.getName());

    public static String readLine() {
        return sc.nextLine();
    }

    public static void printWithNewLine(String message) {
        logger.info(message);
    }
}
