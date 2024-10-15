package core;

import java.util.Scanner;

public class UI {
    Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);
    }

    public void closeScanner() {
        scanner.close();
    }

    public void printDivider() {
        System.out.println();

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - " +
                "- - - - - - - - - - - - - - - -");

        System.out.println();
    }

    public void printNumberedList(String[] entries) {
        for (int i = 0; i < entries.length; i++) {
            System.out.println((i + 1) + ") " + entries[i]);
        }
    }

    public void printPadding(int weight) {
        for (int i = 0; i < weight; i++) {
            System.out.println();
        }
    }

    public void printPrompt(String prompt) {
        System.out.print(prompt + ": ");
    }

    public int printSelectionMenu(String[] entries, String prompt) {
        printNumberedList(entries);

        System.out.println();

        int selection = integerInput(1, entries.length, prompt);

        return selection;
    }

    public int integerInput(Integer min, Integer max, String prompt) {
        try {
            printPrompt(prompt);

            int integer = scanner.nextInt();

            scanner.nextLine();

            while ((min != null && integer < min) || (max != null && integer >
                    max)) {
                System.out.println();

                System.out.print("Please enter a valid integer");

                if (min != null) {
                    System.out.print(" greater than " + (min - 1));
                }

                if (min != null && max != null) {
                    System.out.print(" and");
                }

                if (max != null) {
                    System.out.print(" less than " + (max + 1));
                }

                System.out.println(".");

                System.out.println();

                printPrompt(prompt);

                integer = scanner.nextInt();
            }

            return integer;
        } catch (Exception e) {
            scanner.nextLine();

            System.out.println();

            System.out.println("Please enter a valid integer.");

            System.out.println();

            return integerInput(min, max, prompt);
        }
    }
}