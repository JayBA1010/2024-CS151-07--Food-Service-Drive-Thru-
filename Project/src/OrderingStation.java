import java.util.LinkedList;

public class OrderingStation extends KitchenStation
{
    private LinkedList<Customer> customerQueue;

    public OrderingStation()
    {
        super("Ordering Station", 3, 1);
        
        customerQueue = new LinkedList<Customer>();
    }

    public LinkedList<Customer> getCustomerQueue()
    {
        return customerQueue;
    }

    @Override
    public void useStation(int time)
    {
        Employee employee = getEmployeeQueue().getFirst();

        if(getCustomerQueue().size() > 0 && employee.getTimeAtStation() == 0)
        {
            Customer customer = getCustomerQueue().getFirst();

            getCustomerQueue().removeFirst();

            employee.setCustomer(customer);

            Order order = customer.getOrder();
    
            employee.setIterator(order.getTasks().iterator());

            System.out.println("(Tick " + time + ") " + employee.getName() +
            " (Employee) " + "has received an order of " + order.getName() +
            " from " + customer.getName() + " (Customer).");
        }

        super.useStation(time);
    }
}