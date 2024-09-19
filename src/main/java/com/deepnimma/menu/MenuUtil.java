package com.deepnimma.menu;

import java.util.List;
import java.util.Scanner;

// TODO: Adapt class to use exitIndex and check properly.
// TODO: Create more methods with params and no params and overloading and such.

public class MenuUtil {
    /**
     * Clears the terminal screen
     */
    public static void clear() {
        System.out.print("\033[H\033[2j");
        System.out.flush();
    } // clear

    public static void printOptions(List<String> options, boolean exit) {
        MenuUtil.printOptions(options, exit, 0);
    } // printOption

    public static void printOptions(List<String> options, boolean exit, int exitIndex) {
        if (exitIndex >= 1 && exitIndex <= options.size()) {
            throw new IllegalArgumentException("Exit index must be in a valid range. exitIndex < 1 || exitIndex > options.size()");
        } // if

        for (int i = 0; i < options.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ") " + options.get(i));
        } // for

        if (exit) {
            System.out.println(Integer.toString(exitIndex) + ") Go Back");
        } // if
    } // printOption

    /**
     * Prints the options provided for the specific menu page.
     * @param options What options to print. Printed in the format "x) <your option goes here>"
     * @param prompt Whether to prompt the user for input.
     * @param warning Whether to warn the user about entering a valid integer.
     */
    private static void printOptions(List<String> options, boolean prompt, boolean warning) {
        int size = options.size();

        if (warning) {
            System.out.println("Please enter a valid integer in the range 1-" + Integer.toString(size) + ".\n");
        } // if

        for (int i = 0; i < options.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ") " + options.get(i));
        } // for

        if (prompt) {
            System.out.println("\nPlease choose an option (1 - " + Integer.toString(size) + "): ");
        } // prompt
    } // printOptions

    /**
     * Returns 0-indexed option value chosen by the user.
     * @param options What options to display to the user.
     * @return The 0-indexed option chosen by the user.
     */
    public static int parseInput(List<String> options) {
        boolean inputCheck = true;
        boolean warning = false;
        int size = options.size();
        int input = -1;
        Scanner scanner = new Scanner(System.in);

        while (inputCheck) {
            while (!scanner.hasNextInt()) {
                MenuUtil.clear();
                MenuUtil.printOptions(options, true, warning);
                warning = false;
                scanner.next();
            } // while

            input = scanner.nextInt();

            // Check if it's a valid integer
            if (input < 1 || input > size) {
                warning = true;
                continue;
            } // if

            inputCheck = false;
        } // while

        return input - 1;
    } // parseInput
} // MenuUtil
