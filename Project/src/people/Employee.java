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

    private Iterator<String> currentTask;

    private int timeAtStation;

    /**
     * Constructs a new Employee with the given name and drive-through system.
     *
     * @param name         the name of the employee
     * @param driveThrough the drive-through system where the employee works
     */
    public Employee(DriveThrough driveThrough, String name) {
        super(driveThrough, name);

        customer = null;

        currentTask = null;

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
        if (currentTask != null && currentTask.hasNext()) {
            kitchenStation = switch (currentTask.next()) {
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

        checkPrecedence(kitchenStation);

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
     * Increments the time the employee has spent at the current station.
     */
    public void incrementTimeAtStation() { 
        timeAtStation++;
    }

    public void processOrder(int time) 
    {
        customer = driveThrough.getOrderingStation().getCustomerQueue().getFirst();

        driveThrough.getOrderingStation().getCustomerQueue().removeFirst();

//            Order order = customer.getOrder();

        currentTask = customer.getOrder().getTasks().iterator();

        System.out.println("(Tick " + time + ") " + name +
                " (Employee) " + "has received an order of " + customer.getOrder().getName() +
                " from " + customer.getName() + " (Customer).");
    }

    public void fulfillOrder(int time) 
    {
//            Order order = customer.getOrder();
        double price = customer.getOrder().getPrice();

        driveThrough.incrementCustomersServed();

        driveThrough.addEarnings(price);

        System.out.println("(Tick " + time + ") " + name +
                " (Employee) " + "has fulfilled an order of " + customer.getOrder().getName() +
                " from " + customer.getName() + " (Customer) and earned $" + price
                + ".");
    }

    public void checkPrecedence(KitchenStation kitchenStation) 
    {
        // If the station that employee will move to exists later in the wave compared to the station you just left, ensures time is correct
        if (kitchenStation.getPrecedence() > this.kitchenStation.getPrecedence()) {
            timeAtStation = -1;
        } else {
            timeAtStation = 0;
        }
    }

    //Getters
    /**
     * Gets the current kitchen station of the employee.
     *
     * @return the current kitchen station
     */
    public KitchenStation getKitchenStation() {
        return kitchenStation;
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
     * Gets the iterator for the current tasks of the employee.
     *
     * @return the current task iterator
     */
    public Iterator<String> getCurrentTask() {
        return currentTask;
    }

    /**
     * Gets the time spent at the current station.
     *
     * @return the time at the station
     */
    public int getTimeAtStation() {
        return timeAtStation;
    }

    //Setters
    /**
     * Sets the kitchen station of the employee.
     *
     * @param kitchenStation the kitchen station to set
     */
    public void setKitchenStation(KitchenStation kitchenStation) {
        this.kitchenStation = kitchenStation;
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
     * Sets the iterator for moving between kitchen stations.
     *
     * @param iterator the iterator for station changes
     */
    public void setCurrentTask(Iterator<String> iterator) {
        this.currentTask = iterator;
    }

    /**
     * Sets the time spent at the current station.
     *
     * @param timeAtStation the time to set
     */

     public void setTimeAtStation(int timeAtStation) {
        this.timeAtStation = timeAtStation;
    }
}
