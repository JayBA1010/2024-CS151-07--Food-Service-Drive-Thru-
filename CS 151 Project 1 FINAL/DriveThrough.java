interface serveCustomer {
    void addCustomer(Customer customer);
    void addEarnings(double earnings);
    void addEmployee(Employee employee);
    void incrementCustomersServed();
}

public class DriveThrough implements serveCustomer
{
    private int customersServed;

    private double earnings;
    
    private KitchenStation[] kitchenStations = new KitchenStation[6];

    public DriveThrough()
    {
        customersServed = 0;
        
        earnings = 0;

        kitchenStations[0] = new DessertStation();

        kitchenStations[1] = new FryingStation();

        kitchenStations[2] = new GrillingStation();

        kitchenStations[3] = new OrderingStation();

        kitchenStations[4] = new PickupStation();

        kitchenStations[5] = new PreppingStation();
    }

    public void addCustomer(Customer customer)
    {
        getOrderingStation().getCustomerQueue().add(customer);
    }

    public void addEarnings(double earnings)
    {
        // COULD IMPLEMENT TAX CALCULATION LATER
        
        this.earnings += earnings;
    }

    public void addEmployee(Employee employee)
    {
        getOrderingStation().getEmployeeQueue().add(employee);

        employee.setDriveThrough(this);
    }

    public int getCustomersServed()
    {
        return customersServed;
    }

    public DessertStation getDessertStation()
    {
        return (DessertStation) kitchenStations[0];
    }

    public double getEarnings()
    {
        return earnings;
    }

    public FryingStation getFryingStation()
    {
        return (FryingStation) kitchenStations[1];
    }

    public GrillingStation getGrillingStation()
    {
        return (GrillingStation) kitchenStations[2];
    }

    public KitchenStation[] getKitchenStations()
    {
        return kitchenStations;
    }

    public OrderingStation getOrderingStation()
    {
        return (OrderingStation) kitchenStations[3];
    }

    public PickupStation getPickupStation()
    {
        return (PickupStation) kitchenStations[4];
    }

    public PreppingStation getPreppingStation()
    {
        return (PreppingStation) kitchenStations[5];
    }

    public void incrementCustomersServed()
    {
        customersServed++;
    }
}