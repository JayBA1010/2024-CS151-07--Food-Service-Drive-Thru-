package menuItems;

public class FriedChicken extends Order {
    public FriedChicken() {
        super("Fried Chicken", 9.99);

        getTasks().add("Frying Station");
    }

    public FriedChicken(double price) {
        super("Fried Chicken", price);

        getTasks().add("Frying Station");
    }
}