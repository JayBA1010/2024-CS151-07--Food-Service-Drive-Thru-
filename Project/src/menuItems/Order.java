package menuItems;

import java.util.LinkedList;

public abstract class Order {
    private final String name;

    private final double price;

    private final LinkedList<String> tasks;

    public Order(String name, double price) {
        this.name = name;

        this.price = price;

        tasks = new LinkedList<String>();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public LinkedList<String> getTasks() {
        return tasks;
    }
}