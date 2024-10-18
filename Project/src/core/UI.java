package core;

import java.util.Scanner;

/**
 * The UI class handles user (integer) input and output for the drive-through simulation.
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
    public void closeScanner() { // COUNTS TOWARDS 5 METHOD REQUIREMENT
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
    public void printNumberedList(String[] entries) { // COUNTS TOWARDS 5 METHOD REQUIREMENT
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

    public int integerInput(Integer min, Integer max, String prompt) { // COUNTS TOWARDS 5 METHOD REQUIREMENT
        try
        {
            printPrompt(prompt);
            
            int integer = scanner.nextInt();

            scanner.nextLine();

            while((min != null && integer < min) || (max != null && integer >
            max))
            {
                System.out.println();

                System.out.print("Please enter a valid integer");

                if(min != null)
                {
                    System.out.print(" greater or equal to " + (min));
                }

                if(min != null && max != null)
                {
                    System.out.print(" and");
                }

                if(max != null)
                {
                    System.out.print(" less or equal to " + (max));
                }
                
                System.out.println(".");

                System.out.println();
            
                printPrompt(prompt);
            
                integer = scanner.nextInt();
            }

            return integer;
        }
        catch(Exception e)
        {
            scanner.nextLine();

            System.out.println();
            
            System.out.println("Please enter a valid integer.");

            System.out.println();

            return integerInput(min, max, prompt);
        }
    }

    /**
     * Gets string input.
     */
    public String stringInput(String prompt) { // COUNTS TOWARDS 5 METHOD REQUIREMENT
        printPrompt(prompt);
        return scanner.nextLine();
    }
    /*
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
        */

    public double doubleInput(Double min, Double max, String prompt) { // COUNTS TOWARDS 5 METHOD REQUIREMENT
        try
        {
            printPrompt(prompt);
            
            double input = scanner.nextFloat();

            scanner.nextLine();

            while((min != null && input < min) || (max != null && input >
            max))
            {
                System.out.println();

                System.out.print("Please enter a valid double");

                if(min != null)
                {
                    System.out.print(" greater or equal to " + (min));
                }

                if(min != null && max != null)
                {
                    System.out.print(" and");
                }

                if(max != null)
                {
                    System.out.print(" less or equal to " + (max));
                }
                
                System.out.println(".");

                System.out.println();
            
                printPrompt(prompt);
            
                input = scanner.nextFloat();
            }

            return input;
        }
        catch(Exception e)
        {
            scanner.nextLine();

            System.out.println();
            
            System.out.println("Please enter a valid double.");

            System.out.println();

            return doubleInput(min, max, prompt);
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}