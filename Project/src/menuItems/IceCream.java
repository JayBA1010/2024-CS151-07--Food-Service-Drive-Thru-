package menuItems;

/**
 * The iceCream class represents an order for ice cream in a drive-through simulation.
 * It extends the Order class and initializes the order with a default price or a specified price.
 */
public class IceCream extends Order {
    /**
     * Constructs an IceCream order with a default price of $7.99.
     */
    public IceCream() {
        super("Ice Cream", 3.99);

        getTasks().add("Dessert Station");
    }

    /**
     * Constructs an IceCream order with a specified price.
     *
     * @param price the price of the ice cream
     */
    public IceCream(double price) {
        super("Ice Cream", price);

        getTasks().add("Dessert Station");
    }
}
