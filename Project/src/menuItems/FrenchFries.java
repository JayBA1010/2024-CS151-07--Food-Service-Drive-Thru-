package menuItems;

/**
 * The FrenchFries class represents an order for French fries in a drive-through simulation.
 * It extends the Order class and initializes the order with a default price or a specified price.
 */
public class FrenchFries extends Order {
    /**
     * Constructs a FrenchFries order with a default price of $4.99.
     */
    public FrenchFries() {
        super("French Fries", 4.99);

        getTasks().add("Frying Station");
    }

    /**
     * Constructs a FrenchFries order with a specified price.
     *
     * @param price the price of the French fries
     */
    public FrenchFries(double price) {
        super("French Fries", price);

        getTasks().add("Frying Station");
    }
}
