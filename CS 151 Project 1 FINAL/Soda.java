public class Soda extends Order
{
    public Soda()
    {
        super("Soda", 2.49);
        
        getTasks().add("Dessert Station");
    }

    public Soda(double price)
    {
        super("Soda", price);
        
        getTasks().add("Dessert Station");
    }
}