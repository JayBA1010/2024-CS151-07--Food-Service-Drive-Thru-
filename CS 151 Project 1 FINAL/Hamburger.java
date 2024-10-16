public class Hamburger extends Order
{
    public Hamburger()
    {
        super("Hamburger", 7.99);
        
        getTasks().add("Grilling Station");
        
        getTasks().add("Prepping Station");
    }

    public Hamburger(double price)
    {
        super("Hamburger", price);
        
        getTasks().add("Grilling Station");
        
        getTasks().add("Prepping Station");
    }
}