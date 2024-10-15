package menuItems;

public class GrilledChickenSandwich extends Order {
    public GrilledChickenSandwich() {
        super("Grilled Chicken Sandwich", 9.99);

        getTasks().add("Grilling Station");

        getTasks().add("Prepping Station");
    }
}