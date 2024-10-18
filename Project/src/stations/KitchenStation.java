package stations;

import people.Employee;

import java.util.LinkedList;

/**
 * Represents a station in the kitchen where employees work.
 * Each station has a name, precedence, and a specific duration of use.
 */
public abstract class KitchenStation {
    private LinkedList<Employee> employeeQueue;

    private final String name;

    private final int precedence; // Ensures ordering of stations

    private final int useDuration;

    private boolean isCleaned;

    private boolean isPrepped;

    /**
     * Default constructor for KitchenStation.
     * Initializes the employee queue and sets default values.
     */
    public KitchenStation() {
        employeeQueue = new LinkedList<Employee>();

        name = "";

        precedence = 0;

        useDuration = 0;

        isCleaned = false;

        isPrepped = false;
    }

    /**
     * Constructs a KitchenStation with the given name, precedence, and use duration.
     *
     * @param name        the name of the kitchen station
     * @param precedence  the precedence level of the kitchen station
     * @param useDuration the time it takes to use the station
     */
    public KitchenStation(String name, int precedence, int useDuration) {
        employeeQueue = new LinkedList<Employee>();

        this.name = name;

        this.precedence = precedence;

        this.useDuration = useDuration;
    }

    /**
     * Gets the queue of employees working at this station.
     *
     * @return the queue of employees
     */
    public LinkedList<Employee> getEmployeeQueue() {
        return employeeQueue;
    }

    /**
     * Gets the name of the station.
     *
     * @return the station's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the precedence level of the station.
     *
     * @return the precedence level
     */
    public int getPrecedence() {
        return precedence;
    }

    /**
     * Gets the time it takes to use the station.
     *
     * @return the use duration of the station
     */
    public int getUseDuration() {
        return useDuration;
    }

    public boolean hasEmployee() // COUNTS TOWARDS 5 METHOD REQUIREMENT
    {
        return !employeeQueue.isEmpty();
    }

    /**
     * Simulates an employee using the station at a specific time.
     * The employee's time spent at the station is incremented and displayed.
     *
     * @param time the current time tick
     */
    public void useStation(int time) { // COUNTS TOWARDS 5 METHOD REQUIREMENT
        Employee employee = employeeQueue.getFirst();

        employee.incrementTimeAtStation();

        if (employee.getTimeAtStation() > 0) {
            logAction(employee, time);
        }
    }

    public void logAction(Employee employee, int time) // COUNTS TOWARDS 5 METHOD REQUIREMENT
    {
        System.out.println("(Tick " + time + ") " + employee.getName() +
        " (Employee) " + "has been working at " + name + " for " +
        employee.getTimeAtStation() + " tick" + (employee.getTimeAtStation() == 1 ? "" : "s") + ".");
    }

    public void  logCleaning() // COUNTS TOWARDS 5 METHOD REQUIREMENT
    {
        System.out.println(name + " is being cleaned.");

        isCleaned = true;
    }

    public void logPrepping() // COUNTS TOWARDS 5 METHOD REQUIREMENT
    {
        System.out.println(name + " is being prepped.");

        isPrepped = true;
    }

    public boolean getIsCleaned()
    {
        return isCleaned;
    }

    public boolean getIsPrepped()
    {
        return isPrepped;
    }

    public void setIsCleaned(boolean setting)
    {
        isCleaned = setting;
    }

    public void setIsPrepped(boolean setting)
    {
        isPrepped = setting;
    }
}