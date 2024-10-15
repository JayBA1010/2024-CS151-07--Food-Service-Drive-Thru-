package menuItems;

public class FriedChicken extends Order {
    public FriedChicken() {
        super("Fried Chicken", 9.99);

        getTasks().add("Frying Station");
    }
}