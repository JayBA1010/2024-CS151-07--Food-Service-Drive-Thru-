package people;

import core.DriveThrough;
import stations.KitchenStation;

import java.util.Iterator;

/**
 * Represents an employee working in a drive-through system.
 * The employee handles customers and moves between different kitchen stations.
 */
public class Employee extends Person {
    private KitchenStation kitchenStation;

    private Customer customer;

    private DriveThrough driveThrough;

    private Iterator<String> iterator;

    private int timeAtStation;

    /**
     * Constructs a new Employee with the given name and drive-through system.
     *
     * @param name         the name of the employee
     * @param driveThrough the drive-through system where the employee works
     */
    public Employee(String name, DriveThrough driveThrough) {
        super(name);

        customer = null;

        this.driveThrough = driveThrough;

        iterator = null;

        kitchenStation = driveThrough.getOrderingStation();

        timeAtStation = 0;
    }

    /**
     * Changes the employee's kitchen station, moving them to a new station based on precedence.
     *
     * @param time the current time tick in the simulation
     */
    public void changeKitchenStation(int time) {
        KitchenStation kitchenStation = null;

        // Move to the next station based on the iterator
        if (iterator != null && iterator.hasNext()) {
            kitchenStation = switch (iterator.next()) {
                case "Dessert Station" -> driveThrough.getDessertStation();
                case "Frying Station" -> driveThrough.getFryingStation();
                case "Grilling Station" -> driveThrough.getGrillingStation();
                case "Prepping Station" -> driveThrough.getPreppingStation();
                default -> kitchenStation;
            };
        } else {
            // Move between ordering and pickup stations if no other stations are available
            if (this.kitchenStation == driveThrough.getOrderingStation() || this.kitchenStation == driveThrough.getPickupStation()) {
                kitchenStation = driveThrough.getOrderingStation();
            } else {
                kitchenStation = driveThrough.getPickupStation();
            }
        }

        // Update the time spent at the station based on precedence
        assert kitchenStation != null;

        // If the station that employee will move to exists later in the wave compared to the station you just left, ensures time is correct
        if (kitchenStation.getPrecedence() > this.kitchenStation.getPrecedence()) {
            timeAtStation = -1;
        } else {
            timeAtStation = 0;
        }

        // print the movement to the new station
        System.out.println("(Tick " + time + ") " + name + " (Employee) is m" +
                "oving to " + kitchenStation.getName() + " from " + this.
                kitchenStation.getName() + ".");

        // Update the employee's station
        this.kitchenStation.getEmployeeQueue().remove(this);
        this.kitchenStation = kitchenStation;
        kitchenStation.getEmployeeQueue().add(this);
    }

    /**
     * Gets the customer the employee is currently serving.
     *
     * @return the current customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer the employee is serving.
     *
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets the drive-through system the employee is working in.
     *
     * @return the drive-through system
     */
    public DriveThrough getDriveThrough() {
        return driveThrough;
    }

    /**
     * Sets the drive-through system for the employee.
     *
     * @param driveThrough the drive-through system to set
     */
    public void setDriveThrough(DriveThrough driveThrough) {
        this.driveThrough = driveThrough;
    }

    /**
     * Gets the time spent at the current station.
     *
     * @return the time at the station
     */
    public int getTimeAtStation() {
        return timeAtStation;
    }

    /**
     * Increments the time the employee has spent at the current station.
     */
    public void incrementTimeAtStation() {
        timeAtStation++;
    }

    /**
     * Sets the iterator for moving between kitchen stations.
     *
     * @param iterator the iterator for station changes
     */
    public void setIterator(Iterator<String> iterator) {
        this.iterator = iterator;
    }
}