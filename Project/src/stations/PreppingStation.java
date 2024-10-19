package stations;

/**
 * Represents a prepping station in the kitchen.
 * This station is responsible for prepping orders 
 */
public class PreppingStation extends KitchenStation {
    /**
     * Constructs a new PreppingStation with predefined attributes.
     * The station is named "Prepping Station" with 5 precedence and
     * useDuration of 3 (ticks)
     */
    public PreppingStation() {
        super("Prepping Station", 5, 3);
    }
}
