package core;

import java.util.Scanner;

/**
 * The UI class handles user (integer) input and output for the drive-through simulation.
 */
public class UI implements Formatting {
    Scanner scanner;

    /**
     * Constructs a UI instance with a scanner for user input.
     */

    public UI() {
        scanner = new Scanner(System.in);
    }

    /**
     * Closes the scanner in the UI class.
     */
    public void closeScanner() {
        scanner.close();
    }

    /**
     * Prints a divider line.
     */
    public void printDivider() {
        System.out.println();

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - " +
                "- - - - - - - - - - - - - - - -");

        System.out.println();
    }

    /**
     * Prints a numbered list of entries.
     *
     * @param entries the list of entries to print
     */
    public void printNumberedList(String[] entries) {
        for (int i = 0; i < entries.length; i++) {
            System.out.println((i + 1) + ") " + entries[i]);
        }
    }

    /**
     * Prints empty lines for padding.
     *
     * @param weight the number of empty lines to print
     */
    public void printPadding(int weight) {
        for (int i = 0; i < weight; i++) {
            System.out.println();
        }
    }

    /**
     * Prints a prompt for user input.
     *
     * @param prompt the prompt message to print
     */
    public void printPrompt(String prompt) {
        System.out.print(prompt + ": ");
    }

    /**
     * Prints a selection Menu and returns the selected option.
     *
     * @param entries the options to display
     */
    public void printSelectionMenu(String[] entries) {
        printNumberedList(entries);
        System.out.println();
    }

    /**
     * Prompts the user for an integer input and returns the input.
     *
     * @param min    the minimum acceptable value
     * @param max    the maximum acceptable value (null for no limit)
     * @param prompt the prompt message
     * @return the integer input
     */

    public int integerInput(Integer min, Integer max, String prompt) {
        while (true) {
            try {
                printPrompt(prompt);

                int integer = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer

                if ((min == null || integer >= min) && (max == null || integer <= max)) {
                    return integer;  // Valid input
                }

                // If input is out of range, display error message
                System.out.print("Please enter a valid integer");
                if (min != null) {
                    System.out.print(" greater than or equal to " + min);
                }
                if (max != null) {
                    if (min != null) {
                        System.out.print(" and");
                    }
                    System.out.print(" less than or equal to " + max);
                }
                System.out.println(".");

            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    /**
     * Gets string input.
     */
    public String stringInput() {
        return scanner.nextLine();
    }

    public double doubleInput(String prompt) {
        while (true) {
            try {
                printPrompt(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine();  // Clear buffer
                return value;
            } catch (Exception e) {
                scanner.nextLine();  // Clear the invalid input
                System.out.println("Please enter a valid number.");
            }
        }
    }

}