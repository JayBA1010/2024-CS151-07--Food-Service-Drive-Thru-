import java.util.LinkedList;

abstract class KitchenStation
{
    private LinkedList<Employee> employeeQueue;

    private String name;

    private int precedence;

    private int useDuration;

    public KitchenStation(String name, int precedence, int useDuration)
    {
        employeeQueue = new LinkedList<Employee>();

        this.name = name;

        this.precedence = precedence;

        this.useDuration = useDuration;
    }

    public LinkedList<Employee> getEmployeeQueue()
    {
        return employeeQueue;
    }

    public String getName()
    {
        return name;
    }

    public int getPrecedence()
    {
        return precedence;
    }

    public int getUseDuration()
    {
        return useDuration;
    }

    public void useStation(int time)
    {
        Employee employee = employeeQueue.getFirst();

        employee.incrementTimeAtStation();

        int timeAtStation = employee.getTimeAtStation();

        if(timeAtStation > 0)
        {
            System.out.println("(Tick " + time + ") " + employee.getName() +
            " (Employee) " + "has been working at " + name + " for " +
            timeAtStation + " tick" + (timeAtStation == 1 ? "" : "s") + ".");
        }
    }
}