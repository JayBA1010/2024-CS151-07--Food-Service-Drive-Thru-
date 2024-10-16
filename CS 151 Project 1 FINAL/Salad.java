public class Salad extends Order
{
    public Salad()
    {
        super("Salad", 5.99);
        
        getTasks().add("Prepping Station");
    }

    public Salad(double price)
    {
        super("Salad", price);
        
        getTasks().add("Prepping Station");
    }
}
