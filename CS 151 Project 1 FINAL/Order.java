import java.util.LinkedList;

abstract class Order
{
    private String name;
    
    private double price;
    
    private LinkedList<String> tasks;

    public Order(String name, double price)
    {
        this.name = name;
        
        this.price = price;
        
        tasks = new LinkedList<String>();
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public LinkedList<String> getTasks()
    {
        return tasks;
    }
}