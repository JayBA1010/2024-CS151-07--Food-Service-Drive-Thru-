package people;

import core.DriveThrough;
import menuItems.Order;

/**
 * Represents a customer who places an order at the drive-through.
 */
public class Customer extends Person {
    private Order order;

    /**
     * Creates a new Customer with a name and their order.
     *
     * @param name  the name of the customer
     * @param order the name of the order
     */
    public Customer(DriveThrough driveThrough, String name, Order order) {
        super(driveThrough, name);

        this.order = order;
    }

    /**
     * Gets the order placed by the customer.
     *
     * @return the customer's order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order for the customer.
     *
     * @param order the new order to be placed by the customer
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
