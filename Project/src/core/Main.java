package core;

import people.Customer;
import people.Employee;
import people.Manager;
import stations.KitchenStation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

/**
 * The Main class serves as the entry point for the drive-through simulation program.
 * It manages customer and employee input, runs the simulation, and prints a summary.
 */
public class Main {
    static DriveThrough driveThrough = new DriveThrough();

    static UI ui = new UI();

    /**
     * The main method that starts the drive-through simulation.
     */
    public static void main(String[] args) { // COUNTS TOWARDS 5 METHOD REQUIREMENT


        ui.printDivider();

        // Contributors
        printHeader();

        managerMenu();

        pricingMenu();

        customerMenu();

        employeeMenu();

        int simulationLength = ui.integerInput(0, null, "Simulation Length (Integer)");

        ui.printDivider();

        int pauseInterval = ui.integerInput(1, null, "Pause Interval (Integer)");

        ui.printDivider();

        // Simulation starts here.

        for (KitchenStation kitchenStation : driveThrough.getKitchenStations()) {

            kitchenStation.logPrepping();
        }

        System.out.println();

        for (int time = 0; time < simulationLength; time++) {
            // Like a wave, it does something to a station then moves on to the next
            for (KitchenStation kitchenStation : driveThrough.getKitchenStations()) {
                // Checks if an employee is at the current station
                if (kitchenStation.hasEmployee()) {
                    // True -> Increment timeAtStation
                    kitchenStation.useStation(time);

                    LinkedList<Employee> employeeQueue = kitchenStation.getEmployeeQueue();

                    if (employeeQueue.getFirst().getTimeAtStation() == kitchenStation.getUseDuration()) {
                        employeeQueue.getFirst().changeKitchenStation(time);
                    }
                }
            }

            if (time > 0 && time % pauseInterval == 0) {
                ui.printDivider();
                pauseMenu();
            } else {
                System.out.println();
            }
        }

        for (KitchenStation kitchenStation : driveThrough.getKitchenStations()) {

            kitchenStation.logCleaning();
        }

        ui.printPadding(3);

        System.out.println("Simulation Summary");

        System.out.println();

        System.out.println("Total customers attempted: " + driveThrough.getTotalCustomersAttempted());
        System.out.println("Customers served: " + driveThrough.getCustomersServed());

        int remaining = driveThrough.getTotalCustomersAttempted() - driveThrough.getCustomersServed();

        System.out.println("Customers still waiting: " + remaining);

        System.out.println("Total earnings: " + round(driveThrough.getEarnings(), 2));

        ui.printDivider();

        ui.closeScanner();
    }

    /**
     * Prints the header information for the simulation program.
     * Displays project title and contributor names.
     */
    public static void printHeader() 
    {
        System.out.println("CS 151 Project 1: Drive-through Simulation Progr" +
                "am");
        System.out.println();
        System.out.println("By Aung Aung, Aung Khant \"Junior\" Kyaw, Jay Ba" +
                "rrios Abarquez, and Kenneth\nEstrada");
        ui.printDivider();
    }

    /**
     * Displays the pause menu during the simulation, allowing the user to manage 
     * customers and employees while the simulation is paused.
     */
    public static void pauseMenu() {
        boolean menuActive = true;

        while (menuActive) {
            // Show the menu
            String[] entries = {"Add Customer to the line", "Remove Customer in line", "View Customers in line", "Add Employee"};

            ui.printNumberedList(entries);

            System.out.println("0) Resume Simulation");

            System.out.println();

            int choice = ui.integerInput(0, 4, "(Simulation Paused) Select Action (Integer)");

            if (choice == 0) {
                // Exit the pause setting loop
                menuActive = false;
            } else if (choice == 1) {
                ui.printDivider();
                customerMenu();
            } else if (choice == 2) {
                ui.printDivider();
                if (!driveThrough.getOrderingStation().getCustomerQueue().isEmpty()) {
                    viewCustomerInLine();

                    int integerInput = ui.integerInput(1, driveThrough.getOrderingStation().getCustomerQueue().size(), "Remove Customer (Integer)");
                    driveThrough.getOrderingStation().getCustomerQueue().remove(integerInput - 1);
                    driveThrough.decrementTotalCustomersAttempted();
                } else {
                    System.out.println("There are no customers to remove.");
                }
                ui.printDivider();
            } else if (choice == 3) {
                ui.printDivider();
                if (!driveThrough.getOrderingStation().getCustomerQueue().isEmpty()) {
                    viewCustomerInLine();
                } else {
                    System.out.println("There are no customers in line.");
                }
                ui.printDivider();
            } else {
                ui.printDivider();
                employeeMenu();
            }
        }
        ui.printDivider();
    }

    private static void viewCustomerInLine() {
        for (int i = 0; i < driveThrough.getOrderingStation().getCustomerQueue().size(); i++) {
            System.out.println((i + 1) + ") " + driveThrough.getOrderingStation().getCustomerQueue().get(i).getName() + " (" + driveThrough.getOrderingStation().getCustomerQueue().get(i).getOrder().getName() + ")");
        }

        System.out.println();
    }

    /**
     * Displays the pricing menu that allows the manager to modify item prices in the menu.
     * The manager can select an item to change its price or skip modifying prices.
     */
    public static void pricingMenu() 
    {
        boolean menuActive = true;

        while (menuActive) {
            // Show the menu
            ui.printNumberedList(driveThrough.getMenu().toStringArray());

            System.out.println("0) Skip");

            System.out.println();

            int integerInput = ui.integerInput(0, driveThrough.getMenu().getOrders().length, "Select an item to modify its price (Integer)");

            if (integerInput == 0) {
                // Exit the price setting loop
                menuActive = false;
            } else {
                System.out.println();

                double price = round(ui.doubleInput(0.0, null, "Modify price for " + driveThrough.getMenu().getOrder(integerInput - 1).getName() + " (Double)"), 2);

                switch (integerInput) {
                    case 1:
                        driveThrough.getManager().updateFrenchFriesPrice(price);
                        break;
                    case 2:
                        driveThrough.getManager().updateFriedChickenPrice(price);
                        break;
                    case 3:
                        driveThrough.getManager().updateGrilledChickenPrice(price);
                        break;
                    case 4:
                        driveThrough.getManager().updateGrilledChickenSandwichPrice(price);
                        break;
                    case 5:
                        driveThrough.getManager().updateHamburgerPrice(price);
                        break;
                    case 6:
                        driveThrough.getManager().updateIceCreamPrice(price);
                        break;
                    case 7:
                        driveThrough.getManager().updateSaladPrice(price);
                        break;
                    case 8:
                        driveThrough.getManager().updateSodaPrice(price);
                        break;
                }

                ui.printDivider();
            }
        }

        ui.printDivider();
    }

    /**
     * Gathers input for adding customers to the drive-through line.
     * Prompts the user for the number of customers, their names, and their orders.
     */
    public static void customerMenu() 
    {
        int customerCount = ui.integerInput(0, null, "Customer Count (Integer)");

        ui.printDivider();

        for (int i = 1; i <= customerCount; i++) {
            String name = ui.stringInput("Customer " + i + "'s Name (String)");

            ui.printPadding(3);

            ui.printNumberedList(driveThrough.getMenu().toStringArray());

            System.out.println();

            int integerInput = ui.integerInput(1, driveThrough.getMenu().getOrders().length, "Customer " + i + "'s Order (Integer)");

            //System.out.println();

            //String selectedItem = orders[index - 1];

            //System.out.println(name + " will order: " + selectedItem);

            ui.printDivider();

            driveThrough.addCustomer(new Customer(driveThrough, name, driveThrough.getMenu().getOrder(integerInput - 1)));
        }
    }

    /**
     * Gathers input for adding employees to the drive-through.
     * Prompts the user for the number of employees and their names, 
     * assigning them to the ordering station by default.
     */
    public static void employeeMenu() 
    {
        int employeeCount = ui.integerInput(0, null, "Employee Count (Integer)");

        ui.printDivider();

        for (int i = 1; i <= employeeCount; i++) {
            String name = ui.stringInput("Employee " + i + "'s Name (String)");

            ui.printDivider();

            // All employees start at the ordering station
            driveThrough.addEmployee(new Employee(driveThrough, name));
        }
    }

    /**
     * Gathers input for setting the manager of the drive-through.
     * Prompts the user for the manager's name and assigns them to the drive-through.
     */
    public static void managerMenu() {
        String name = ui.stringInput("Manager's Name (String)");

        driveThrough.setManager(new Manager(driveThrough, name));

        ui.printDivider();
    }

    // A handy rounding method from https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places.
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
