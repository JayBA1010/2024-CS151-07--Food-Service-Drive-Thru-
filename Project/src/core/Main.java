package core;

import menuItems.Menu;
import people.Customer;
import people.Employee;
import stations.KitchenStation;

import java.util.LinkedList;

/**
 * The Main class serves as the entry point for the drive-through simulation program.
 * It manages customer and employee input, runs the simulation, and prints a summary.
 */
public class Main {

    /**
     * The main method that starts the drive-through simulation.
     */
    public static void main(String[] args) {
        DriveThrough driveThrough = new DriveThrough();

        UI ui = new UI();

        // Contributors

        ui.printDivider();
        System.out.println("CS 151 Project 1: Drive-through Simulation Progr" +
                "am");
        System.out.println();
        System.out.println("By Aung Aung, Aung Khant \"Junior\" Kyaw, Jay Ba" +
                "rrios Abarquez, and Kenneth\nEstrada");
        ui.printDivider();

        // Start of Program

        String[] menuItems = {"French Fries", "Fried Chicken", "Grilled Chicken", "Grilled Chicken Sandwich", "Hamburger", "Ice Cream", "Salad", "Soda"};

        boolean settingPrices = true;
        while (settingPrices) {
            // Show the menu
            ui.printSelectionMenu(menuItems);
            int choice = ui.integerInput(0, menuItems.length, "Select an item to set the price (0 to move to the next step)");

            if (choice == 0) {
                // Exit the price setting loop
                settingPrices = false;
            } else {
                // Set price for the selected item
                String selectedItem = menuItems[choice - 1];  // Adjust for 0-based index
                double price = ui.doubleInput("Set price for " + selectedItem);

                switch (selectedItem) {
                    case "French Fries":
                        Menu.updateFrenchFriesPrice(price);
                        break;
                    case "Fried Chicken":
                        Menu.updateFriedChickenPrice(price);
                        break;
                    case "Grilled Chicken":
                        Menu.updateGrilledChickenPrice(price);
                        break;
                    case "Grilled Chicken Sandwich":
                        Menu.updateGrilledChickenSandwichPrice(price);
                        break;
                    case "Hamburger":
                        Menu.updateHamburgerPrice(price);
                        break;
                    case "Ice Cream":
                        Menu.updateIceCreamPrice(price);
                        break;
                    case "Salad":
                        Menu.updateSaladPrice(price);
                        break;
                    case "Soda":
                        Menu.updateSodaPrice(price);
                        break;
                }

                ui.printDivider();
            }
        }

        int customerCount = ui.integerInput(0, null, "Customer Count (Integer)");

        ui.printDivider();

        for (int i = 1; i <= customerCount; i++) {
            ui.printPrompt("Customer " + i + "'s Name (String)");

            String name = ui.stringInput();

            ui.printPadding(3);

            String[] orders = {"French Fries", "Fried Chicken", "Grilled Chicken", "Grilled Chicken Sandwich", "Hamburger", "Ice Cream", "Salad", "Soda"};

            ui.printSelectionMenu(orders);
            int index = ui.integerInput(1, orders.length - 1, "Customer " + i + "'s Order");
            String selectedItem = menuItems[index - 1];
            System.out.println(name + " will order: " + selectedItem);

            ui.printDivider();

            driveThrough.addCustomer(new Customer(name, orders[index - 1]));

        }

        int employeeCount = ui.integerInput(0, null, "Employee Count (Integer)");

        ui.printDivider();

        for (int i = 1; i <= employeeCount; i++) {
            ui.printPrompt("Employee " + i + "'s Name (String)");

            String name = ui.stringInput();

            ui.printDivider();

            // All employees start at station 1 (the ordering station)
            driveThrough.addEmployee(new Employee(name, driveThrough));
        }

        int simulationLength = ui.integerInput(0, null, "Simulation Length (Integer)");

        ui.printDivider();

        // Simulation starts here.

        for (int time = 0; time < simulationLength; time++) {
            // Like a wave, it does something to a station then moves on to the next
            for (KitchenStation kitchenStation : driveThrough.getKitchenStations()) {

                LinkedList<Employee> employeeQueue = kitchenStation.getEmployeeQueue();

                // Checks if an employee is at the current station
                if (!employeeQueue.isEmpty()) {
                    // True -> Increment timeAtStation
                    kitchenStation.useStation(time);

                    if (employeeQueue.getFirst().getTimeAtStation() == kitchenStation.getUseDuration()) {
                        employeeQueue.getFirst().changeKitchenStation(time);
                    }
                }
            }
            ui.printDivider();
        }

        ui.printPadding(3);

        System.out.println("Simulation Summary");

        System.out.println();

        System.out.println("Customers served: " + driveThrough.getCustomersServed());

        System.out.println("Total earnings: " + driveThrough.getEarnings());

        ui.printDivider();

        ui.closeScanner();
    }
}