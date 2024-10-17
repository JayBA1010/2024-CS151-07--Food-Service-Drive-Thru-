package core;

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

        ui.printDivider();
        System.out.println("CS 151 Project 1: Drive-through Simulation Progr" +
                "am");
        System.out.println();
        System.out.println("By Aung Aung, Aung Khant \"Junior\" Kyaw, Jay Ba" +
                "rrios Abarquez, and Kenneth\nEstrada");
        ui.printDivider();

        int customerCount = ui.integerInput(0, null, "Customer Count (Intege" +
                "r)");

        ui.printDivider();

        for (int i = 1; i <= customerCount; i++) {
            ui.printPrompt("Customer " + i + "'s Name (String)");

            String name = ui.stringInput();

            ui.printPadding(3);

            String[] orders = {"French Fries", "Fried Chicken", "Grilled Chi" +
                    "cken", "Grilled Chicken Sandwich", "Hamburger", "Ice Cream", "S" +
                    "alad", "Soda"};

            int index = ui.printSelectionMenu(orders, "Customer " + i + "'s Order") - 1;

            ui.printDivider();

            // All customers start at station 1 (the ordering station)
            driveThrough.addCustomer(new Customer(name, orders[index]));

        }

        int employeeCount = ui.integerInput(0, null, "Employee Count (Intege" +
                "r)");

        ui.printDivider();

        for (int i = 1; i <= employeeCount; i++) {
            ui.printPrompt("Employee " + i + "'s Name (String)");

            String name = ui.stringInput();

            ui.printDivider();

            // All employees start at station 1 (the ordering station)
            driveThrough.addEmployee(new Employee(name, driveThrough));
        }

        int simulationLength = ui.integerInput(0, null, "Simulation Length (" +
                "Integer)");

        ui.printDivider();

        // Simulation starts here.

        for (int time = 0; time < simulationLength; time++) {
            // Like a wave, it does something to a station then moves on to the next
            for (KitchenStation kitchenStation : driveThrough.getKitchenStations()) {

                LinkedList<Employee> employeeQueue = kitchenStation.getEmployeeQueue();

                // Checks if an employee is at the current station
                if (!employeeQueue.isEmpty()) {
                    // True ->
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