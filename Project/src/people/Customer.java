package people;

import menuItems.*;

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
    public Customer(String name, String order) {
        super(name);

        switch (order) {
            case "French Fries":
                this.order = new FrenchFries(5.99);

                break;
            case "Fried Chicken":
                this.order = new FriedChicken(10.99);

                break;
            case "Grilled Chicken":
                this.order = new GrilledChicken(15.99);

                break;
            case "Grilled Chicken Sandwich":
                this.order = new GrilledChickenSandwich(10.99);

                break;
            case "Hamburger":
                this.order = new Hamburger();

                break;
            case "Ice Cream":
                this.order = new IceCream();

                break;
            case "Salad":
                this.order = new Salad();

                break;
            case "Soda":
                this.order = new Soda();

                break;
        }
    }

    /**
     * Gets the order placed by the customer.
     *
     * @return the customer's order
     */
    public Order getOrder() {
        return order;
    }
}