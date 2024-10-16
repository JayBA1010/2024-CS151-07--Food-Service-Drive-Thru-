import java.util.Iterator;

public class Employee extends Person
{
    private KitchenStation kitchenStation;
    
    private Customer customer;
    
    private DriveThrough driveThrough;

    private Iterator<String> iterator;

    private int timeAtStation;

    public Employee(String name, DriveThrough driveThrough)
    {
        super(name);

        customer = null;

        this.driveThrough = driveThrough;

        iterator = null;

        kitchenStation = driveThrough.getOrderingStation();

        timeAtStation = 0;
    }
    
    public void changeKitchenStation(int time)
    {   
        KitchenStation kitchenStation = null;

        if(iterator != null && iterator.hasNext() == true)
        {
            switch(iterator.next())
            {
                case "Dessert Station":
                    kitchenStation = driveThrough.getDessertStation();

                    break;
                case "Frying Station":
                    kitchenStation = driveThrough.getFryingStation();

                    break;
                case "Grilling Station":
                    kitchenStation = driveThrough.getGrillingStation();

                    break;
                case "Prepping Station":
                    kitchenStation = driveThrough.getPreppingStation();

                    break;
            }
        }
        else
        {
            if(this.kitchenStation == driveThrough.getOrderingStation() || this.kitchenStation == driveThrough.getPickupStation())
            {
                kitchenStation = driveThrough.getOrderingStation();
            }
            else
            {
                kitchenStation = driveThrough.getPickupStation();
            }
        }

        if(kitchenStation.getPrecedence() > this.kitchenStation.getPrecedence())
        {
            timeAtStation = -1;
        }
        else
        {
            timeAtStation = 0;
        }

        System.out.println("(Tick " + time + ") " + name + " (Employee) is m" +
        "oving to " + kitchenStation.getName() + " from " + this.
        kitchenStation.getName() + ".");
        
        this.kitchenStation.getEmployeeQueue().remove(this);

        this.kitchenStation = kitchenStation;

        kitchenStation.getEmployeeQueue().add(this);
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public DriveThrough getDriveThrough()
    {
        return driveThrough;
    }
    
    public int getTimeAtStation()
    {
        return timeAtStation;
    }

    public void incrementTimeAtStation()
    {
        timeAtStation++;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public void setDriveThrough(DriveThrough driveThrough)
    {
        this.driveThrough = driveThrough;
    }

    public void setIterator(Iterator<String> iterator)
    {
        this.iterator = iterator;
    }
}