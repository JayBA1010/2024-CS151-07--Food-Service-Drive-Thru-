package menuItems;

/**
 * The Hamburger class represents an order for hamburgers in a drive-through simulation.
 * It extends the Order class and initializes the order with a default price or a specified price.
 */
public class Hamburger extends Order {
    /**
     * Constructs a Hamburger order with a default price of $7.99.
     */
    public Hamburger() {
        super("Hamburger", 7.99);

        getTasks().add("Grilling Station");

        getTasks().add("Prepping Station");
    }

    /**
     * Constructs a Hamburger order with a specified price.
     *
     * @param price the price of the hamburger
     */
    public Hamburger(double price) {
        super("Hamburger", price);

        getTasks().add("Grilling Station");

        getTasks().add("Prepping Station");
    }
}
