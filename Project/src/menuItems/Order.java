package menuItems;

import java.util.LinkedList;

/**
 * Represents a general order with a name, price, and list of tasks to complete it.
 */
public abstract class Order {
    private final String name;

    private final double price;

    private final LinkedList<String> tasks;

    /**
     * Creates an Order with the given name and price.
     *
     * @param name  the name of the order
     * @param price the price of the order
     */
    public Order(String name, double price) {
        this.name = name;

        this.price = price;

        tasks = new LinkedList<String>();
    }

    /**
     * Gets the name of the order.
     *
     * @return the order name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the order.
     *
     * @return the order price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the list of tasks to prepare the order.
     *
     * @return the task list
     */
    public LinkedList<String> getTasks() {
        return tasks;
    }
}