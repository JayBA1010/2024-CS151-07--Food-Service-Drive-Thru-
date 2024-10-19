package menuItems;

/**
 * The GrilledChickenSandwich class represents an order for grilled chicken sandwiches in a drive-through simulation.
 * It extends the Order class and initializes the order with a default price or a specified price.
 */
public class GrilledChickenSandwich extends Order {
    /**
     * Constructs a GrilledChickenSandwich order with a default price of $9.99.
     */
    public GrilledChickenSandwich() {
        super("Grilled Chicken Sandwich", 9.99);

        getTasks().add("Grilling Station");

        getTasks().add("Prepping Station");
    }

    /**
     * Constructs a GrilledChickenSandwich order with a specified price.
     *
     * @param price the price of the grilled chicken sandwich
     */
    public GrilledChickenSandwich(double price) {
        super("Grilled Chicken Sandwich", price);

        getTasks().add("Grilling Station");

        getTasks().add("Prepping Station");
    }
}
