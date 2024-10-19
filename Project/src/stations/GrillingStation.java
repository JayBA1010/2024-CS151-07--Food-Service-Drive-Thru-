package stations;

/**
 * Represents a grilling station in the kitchen.
 * This station is responsible for handling grilling orders 
 */
public class GrillingStation extends KitchenStation {
    /**
     * Constructs a new GrillingStation with predefined attributes.
     * The station is named "Grilling Station" with 2 precedence and
     * useDuration of 9 (ticks)
     */
    public GrillingStation() {
        super("Griling Station", 2, 9);
    }
}
