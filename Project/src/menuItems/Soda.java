package menuItems;

/**
 * The Soda class represents an order for sodas in a drive-through simulation.
 * It extends the Order class and initializes the order with a default price or a specified price.
 */
public class Soda extends Order {
    /**
     * Constructs a Soda order with a default price of $2.49.
     */
    public Soda() {
        super("Soda", 2.49);

        getTasks().add("Dessert Station");
    }

    /**
     * Constructs a Soda order with a specified price.
     *
     * @param price the price of the soda
     */
    public Soda(double price) {
        super("Soda", price);

        getTasks().add("Dessert Station");
    }
}
