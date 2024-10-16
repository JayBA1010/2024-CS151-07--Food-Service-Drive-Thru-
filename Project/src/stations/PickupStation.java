package stations;

import core.DriveThrough;
import menuItems.Order;
import people.Customer;
import people.Employee;

public class PickupStation extends KitchenStation {
    public PickupStation() {
        super("Pickup Station", 4, 1);
    }

    @Override
    public void useStation(int time) {
        Employee employee = getEmployeeQueue().getFirst();

        if (employee.getTimeAtStation() == 0) {
            Customer customer = employee.getCustomer();

            DriveThrough driveThrough = employee.getDriveThrough();

            Order order = customer.getOrder();

            double price = order.getPrice();

            driveThrough.incrementCustomersServed();

            driveThrough.addEarnings(price);

            System.out.println("(Tick " + time + ") " + employee.getName() +
                    " (Employee) " + "has fulfilled an order of " + order.getName() +
                    " from " + customer.getName() + " (Customer) and earned $" + price
                    + ".");
        }

        super.useStation(time);
    }
}