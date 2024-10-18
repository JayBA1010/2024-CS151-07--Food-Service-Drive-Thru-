package stations;

import people.Customer;
import people.Employee;

import java.util.LinkedList;

public class OrderingStation extends KitchenStation {
    private final LinkedList<Customer> customerQueue;

    public OrderingStation() {
        super("Ordering Station", 3, 1);
        customerQueue = new LinkedList<>();
    }

    public LinkedList<Customer> getCustomerQueue() {
        return customerQueue;
    }

    @Override
    public void useStation(int time) {
        Employee employee = getEmployeeQueue().getFirst();

        if (!getCustomerQueue().isEmpty() && employee.getTimeAtStation() == 0) {
            employee.processOrder(time);
        }

        super.useStation(time);
    }
}