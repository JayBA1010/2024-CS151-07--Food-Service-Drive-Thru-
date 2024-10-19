package core;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The UI class handles user input and output for the drive-through simulation.
 */
public class UI implements Formatting {
    private Scanner scanner;

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
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    /**
     * Prompts the user for a string input.
     *
     * @param prompt the message to prompt the user for input
     * @return the string input from the user
     */
    public String stringInput(String prompt) { 
        printPrompt(prompt);
        return scanner.nextLine();
    }


    /**
     * Prompts the user for a double input within a specified range.
     * If the input is invalid or outside the range, the user is prompted again.
     *
     * @param min    the minimum acceptable value 
     * @param max    the maximum acceptable value 
     * @param prompt the message to prompt the user for input
     * @return the valid double input from the user
     */
    public double doubleInput(Double min, Double max, String prompt) {
        while (true) {
            try {
                printPrompt(prompt);
                double input = scanner.nextDouble();
                scanner.nextLine();  // Clear the buffer

                // Check if input is within the valid range
                if ((min == null || input >= min) && (max == null || input <= max)) {
                    return input;  // Valid input
                }

                // If input is out of range, display error message
                System.out.print("Please enter a valid double");
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

            } catch (InputMismatchException e) {
                // Handle non-numeric input
                scanner.nextLine();  // Clear the invalid input from the buffer
                System.out.println("Please enter a valid double.");
            }
        }
    }

    //Getters
    /**
     * Returns the scanner used for user input
     *
     * @return the scanner object
     */
    public Scanner getScanner() {
        return scanner;
    }

    //Setters
    /**
     * Sets the scanner for user input
     *
     * @param scanner the scanner object to set
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
