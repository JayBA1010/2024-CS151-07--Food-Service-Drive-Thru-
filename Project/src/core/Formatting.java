package core;

interface Formatting {
    void printDivider();

    void printNumberedList(String[] entries);

    void printPadding(int weight);

    void printPrompt(String prompt);

    void printSelectionMenu(String[] entries);
}