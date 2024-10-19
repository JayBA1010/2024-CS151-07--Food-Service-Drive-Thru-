package menuItems;

/**
 * The FriedChicken class represents an order for fried chicken in a drive-through simulation.
 * It extends the Order class and initializes the order with a default price or a specified price.
 */
public class FriedChicken extends Order {
    /**
     * Constructs a FriedChicken order with a default price of $9.99.
     */
    public FriedChicken() {
        super("Fried Chicken", 9.99);

        getTasks().add("Frying Station");
    }

    /**
     * Constructs a FriedChicken order with a specified price.
     *
     * @param price the price of the fried chicken
     */
    public FriedChicken(double price) {
        super("Fried Chicken", price);

        getTasks().add("Frying Station");
    }
}
