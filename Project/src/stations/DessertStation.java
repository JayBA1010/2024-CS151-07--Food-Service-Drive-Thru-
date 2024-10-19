package stations;

/**
 * Represents a dessert preparation station in the kitchen.
 * This station is responsible for handling dessert orders 
 */
public class DessertStation extends KitchenStation {
    /**
     * Constructs a new DessertStation with predefined attributes.
     * The station is named "Dessert Station" with 0 precedence and
     * useDuration of 5 (ticks)
     */
    public DessertStation() {
        super("Dessert Station", 0, 5);
    }
}
