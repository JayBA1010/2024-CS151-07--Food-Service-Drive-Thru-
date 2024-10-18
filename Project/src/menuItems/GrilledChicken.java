package menuItems;

public class GrilledChicken extends Order {
    public GrilledChicken() {
        super("Grilled Chicken", 14.99);

        getTasks().add("Grilling Station");
    }

    public GrilledChicken(double price) {
        super("Grilled Chicken", price);

        getTasks().add("Grilling Station");
    }
}