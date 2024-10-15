package menuItems;

public class GrilledChicken extends Order {
    public GrilledChicken() {
        super("Grilled Chicken", 14.99);

        getTasks().add("Grilling Station");
    }
}