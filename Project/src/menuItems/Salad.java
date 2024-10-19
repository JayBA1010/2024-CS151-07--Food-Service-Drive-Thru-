package menuItems;

/**
 * The Salad class represents an order for salads in a drive-through simulation.
 * It extends the Order class and initializes the order with a default price or a specified price.
 */
public class Salad extends Order {
    /**
     * Constructs a Salad order with a default price of $5.99.
     */
    public Salad() {
        super("Salad", 5.99);

        getTasks().add("Prepping Station");
    }

    /**
     * Constructs a Salad order with a specified price.
     *
     * @param price the price of the salad
     */
    public Salad(double price) {
        super("Salad", price);

        getTasks().add("Prepping Station");
    }
}
