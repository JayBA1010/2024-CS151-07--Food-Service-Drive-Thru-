package menuItems;

/**
 * The GrilledChicken class represents an order for grilled chicken in a drive-through simulation.
 * It extends the Order class and initializes the order with a default price or a specified price.
 */
public class GrilledChicken extends Order {
    /**
     * Constructs a GrilledChicken order with a default price of $14.99.
     */
    public GrilledChicken() {
        super("Grilled Chicken", 14.99);

        getTasks().add("Grilling Station");
    }

    /**
     * Constructs a GrilledChicken order with a specified price.
     *
     * @param price the price of the grilled chicken
     */
    public GrilledChicken(double price) {
        super("Grilled Chicken", price);

        getTasks().add("Grilling Station");
    }
}
