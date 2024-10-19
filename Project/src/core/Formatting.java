package core;

/**
 * Provides methods for formatting and displaying output in a user interface.
 * This interface defines common printing operations to enhance the UI experience.
 */
interface Formatting {
    void printDivider();

    void printNumberedList(String[] entries);

    void printPadding(int weight);

    void printPrompt(String prompt);
}
