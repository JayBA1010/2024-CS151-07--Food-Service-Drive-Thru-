package menuItems;

public class Salad extends Order {
    public Salad() {
        super("Salad", 5.99);

        getTasks().add("Prepping Station");
    }
}
