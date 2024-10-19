package stations;

import people.Employee;

/**
 * Represents a pick up station in the kitchen.
 * This station is responsible for handling picking up orders 
 */
public class PickupStation extends KitchenStation {
    /**
     * Constructs a new PickupStation with predefined attributes.
     * The station is named "Pickup Station" with 4 precedence and
     * useDuration of 1 (ticks)
     */
    public PickupStation() {
        super("Pickup Station", 4, 1);
    }

    /**
     * Simulates an employee using the pickup station at a specific time.
     * If the employee's time at the station is zero, the employee fulfills the order
     * for the customer.
     *
     * @param time the current time tick
     */
    @Override
    public void useStation(int time) {
        Employee employee = getEmployeeQueue().getFirst();

        if (employee.getTimeAtStation() == 0) {
            employee.fulfillOrder(time);
        }

        super.useStation(time);
    }
}
