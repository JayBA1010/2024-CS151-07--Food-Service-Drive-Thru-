package menuItems;

public class IceCream extends Order {
    public IceCream() {
        super("Ice Cream", 3.99);

        getTasks().add("Dessert Station");
    }
}