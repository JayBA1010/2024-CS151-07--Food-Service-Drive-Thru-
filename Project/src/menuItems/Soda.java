package menuItems;

public class Soda extends Order {
    public Soda() {
        super("Soda", 2.49);

        getTasks().add("Dessert Station");
    }
}