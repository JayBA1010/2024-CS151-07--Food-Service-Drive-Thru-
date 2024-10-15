package core;

public interface UIInterface {
    void printDivider();
    void printNumberedList(String[] entries);
    void printPadding(int weight);
    void printPrompt(String prompt);
    int printSelectionMenu(String[] entries, String prompt);
    int integerInput(Integer min, Integer max, String prompt);
}
