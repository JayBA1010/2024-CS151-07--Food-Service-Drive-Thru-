package core;

interface Formatting {
    void printDivider();

    void printNumberedList(String[] entries);

    void printPadding(int weight);

    void printPrompt(String prompt);

    int printSelectionMenu(String[] entries, String prompt);
}