package stations;

import people.Customer;
import people.Employee;

import java.util.LinkedList;

/**
 * Represents the ordering station in the kitchen where customers place their orders.
 * This station handles customer interactions and manages the queue of customers
 * waiting to be served
 */
public class OrderingStation extends KitchenStation {
    private final LinkedList<Customer> customerQueue;

    /**
     * Constructs an OrderingStation with a predefined name, precedence, and use duration.
     * Initializes the customer queue for handling incoming orders.
     */
    public OrderingStation() {
        super("Ordering Station", 3, 1);
        customerQueue = new LinkedList<>();
    }

    /**
     * Simulates an employee using the ordering station at a specific time.
     * If there are customers in the queue and the employee's time at the station is zero,
     * the employee processes the next customer's order.
     *
     * @param time the current time tick
     */
    @Override
    public void useStation(int time) {
        Employee employee = getEmployeeQueue().getFirst();

        if (!getCustomerQueue().isEmpty() && employee.getTimeAtStation() == 0) {
            employee.processOrder(time);
        }

        super.useStation(time);
    }

    //Getters
    /**
     * Gets the queue of customers waiting to place their orders.
     *
     * @return the queue of customers
     */
    public LinkedList<Customer> getCustomerQueue() {
        return customerQueue;
    }
}
