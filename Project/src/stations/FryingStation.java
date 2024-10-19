package stations;

/**
 * Represents a frying station in the kitchen.
 * This station is responsible for handling frying orders 
 */
public class FryingStation extends KitchenStation {
    /**
     * Constructs a new FryingStation with predefined attributes.
     * The station is named "Frying Station" with 1 precedence and
     * useDuration of 7 (ticks)
     */
    public FryingStation() {
        super("Frying Station", 1, 7);
    }
}
