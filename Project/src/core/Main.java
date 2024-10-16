package core;

import people.Customer;
import people.Employee;
import stations.KitchenStation;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
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

            Scanner scanner = new Scanner(System.in);

            String name = scanner.nextLine();

            ui.printPadding(3);

            scanner.close();

            String[] orders = {"French Fries", "Fried Chicken", "Grilled Chi" +
                    "cken", "Grilled Chicken Sandwich", "Hamburger", "Ice Cream", "S" +
                    "alad", "Soda"};

            int index = ui.printSelectionMenu(orders, "Customer " + i + "'s Order") - 1;

            ui.printDivider();

            driveThrough.addCustomer(new Customer(name, orders[index]));

        }

        int employeeCount = ui.integerInput(0, null, "Employee Count (Intege" +
                "r)");

        ui.printDivider();

        for (int i = 1; i <= employeeCount; i++) {
            ui.printPrompt("Employee " + i + "'s Name (String)");

            Scanner scanner = new Scanner(System.in);

            String name = scanner.nextLine().strip();

            ui.printDivider();

            scanner.close();

            driveThrough.addEmployee(new Employee(name, driveThrough));
        }

        int simulationLength = ui.integerInput(0, null, "Simulation Length (" +
                "Integer)");

        ui.printDivider();

        // Simulation starts here.

        for (int time = 0; time < simulationLength; time++) {
            for (KitchenStation kitchenStation : driveThrough.
                    getKitchenStations()) {
                LinkedList<Employee> employeeQueue = kitchenStation.getEmployeeQueue();

                if (employeeQueue.size() > 0) {
                    kitchenStation.useStation(time);

                    if (employeeQueue.getFirst().
                            getTimeAtStation() == kitchenStation.getUseDuration()) {
                        employeeQueue.getFirst().changeKitchenStation(time);
                    }
                }
            }
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