package menuItems;


public class FrenchFries extends Order {
    public FrenchFries() {
        super("French Fries", 4.99);

        getTasks().add("Frying Station");
    }

    public FrenchFries(double price) {
        super("French Fries", price);

        getTasks().add("Frying Station");
    }
}
