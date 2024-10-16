public class IceCream extends Order
{
    public IceCream()
    {
        super("Ice Cream", 3.99);
        
        getTasks().add("Dessert Station");
    }

    public IceCream(double price)
    {
        super("Ice Cream", price);
        
        getTasks().add("Dessert Station");
    }
}