package people;

import menuItems.Menu;
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
    public Customer(String name, String order) {
        super(name);

        switch (order) {
            case "French Fries":
                this.order = Menu.getFrenchFries();

                break;
            case "Fried Chicken":
                this.order = Menu.getFriedChicken();

                break;
            case "Grilled Chicken":
                this.order = Menu.getGrilledChicken();

                break;
            case "Grilled Chicken Sandwich":
                this.order = Menu.getGrilledChickenSandwich();

                break;
            case "Hamburger":
                this.order = Menu.getHamburger();

                break;
            case "Ice Cream":
                this.order = Menu.getIceCream();

                break;
            case "Salad":
                this.order = Menu.getSalad();

                break;
            case "Soda":
                this.order = Menu.getSoda();

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