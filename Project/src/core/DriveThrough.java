package core;

import menuItems.Menu;
import people.Customer;
import people.Employee;
import people.ServeCustomer;
import stations.*;

/**
 * The DriveThrough class simulates the operations of a drive-through restaurant.
 * It manages customers, employees, and kitchen stations, tracking the number of
 * customers served and the earnings.
 */
public class DriveThrough implements ServeCustomer {
    private final KitchenStation[] kitchenStations = new KitchenStation[6];
    private int customersServed;
    private double earnings;

    /**
     * Constructs a DriveThrough instance with predefined kitchen stations.
     */
    public DriveThrough() {
        customersServed = 0;

        earnings = 0;

        kitchenStations[0] = new DessertStation();

        kitchenStations[1] = new FryingStation();

        kitchenStations[2] = new GrillingStation();

        kitchenStations[3] = new OrderingStation();

        kitchenStations[4] = new PickupStation();

        kitchenStations[5] = new PreppingStation();
    }

    /**
     * Adds a customer to the ordering station's queue.
     *
     * @param customer the customer to add
     */
    public void addCustomer(Customer customer) {
        getOrderingStation().getCustomerQueue().add(customer);
    }

    /**
     * Adds earnings to the total earnings.
     *
     * @param earnings the earnings to add
     */
    public void addEarnings(double earnings) {
        // COULD IMPLEMENT TAX CALCULATION LATER

        this.earnings += earnings;
    }

    /**
     * Adds an employee to the ordering station's queue and sets the employee's drive-through.
     *
     * @param employee the employee to add
     */
    public void addEmployee(Employee employee) {
        getOrderingStation().getEmployeeQueue().add(employee);

        employee.setDriveThrough(this);
    }

    /**
     * Returns the total number of customers served.
     *
     * @return the number of customers served
     */
    public int getCustomersServed() {
        return customersServed;
    }

    /**
     * Returns the dessert station.
     *
     * @return the dessert station
     */
    public DessertStation getDessertStation() {
        return (DessertStation) kitchenStations[0];
    }

    /**
     * Returns the total earnings.
     *
     * @return the total earnings
     */
    public double getEarnings() {
        return earnings;
    }

    /**
     * Returns the frying station.
     *
     * @return the frying station
     */
    public FryingStation getFryingStation() {
        return (FryingStation) kitchenStations[1];
    }

    /**
     * Returns the grilling station.
     *
     * @return the grilling station
     */
    public GrillingStation getGrillingStation() {
        return (GrillingStation) kitchenStations[2];
    }

    /**
     * Returns all the kitchen stations.
     *
     * @return an array of kitchen stations
     */
    public KitchenStation[] getKitchenStations() {
        return kitchenStations;
    }

    /**
     * Returns the ordering station.
     *
     * @return the ordering station
     */
    public OrderingStation getOrderingStation() {
        return (OrderingStation) kitchenStations[3];
    }

    /**
     * Returns the pickup station.
     *
     * @return the pickup station
     */
    public PickupStation getPickupStation() {
        return (PickupStation) kitchenStations[4];
    }

    /**
     * Returns the prepping station.
     *
     * @return the prepping station
     */
    public PreppingStation getPreppingStation() {
        return (PreppingStation) kitchenStations[5];
    }

    /**
     * Increments the number of customers served.
     */
    public void incrementCustomersServed() {
        customersServed++;
    }
}