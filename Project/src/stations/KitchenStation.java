package stations;

import people.Employee;
import java.util.LinkedList;

/**
 * Represents a station in the kitchen where employees work.
 * Each station has a name, precedence, and a specific duration of use.
 */
public abstract class KitchenStation {
    private final String name;
    private final int precedence; // Ensures ordering of stations
    private final int useDuration;
    private final LinkedList<Employee> employeeQueue;
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
     * Checks if there is at least one employee assigned to the station.
     *
     * @return true if the employee queue is not empty, false otherwise
     */
    public boolean hasEmployee()
    {
        return !employeeQueue.isEmpty();
    }

    /**
     * Simulates an employee using the station at a specific time.
     * The employee's time spent at the station is incremented and displayed.
     *
     * @param time the current time tick
     */
    public void useStation(int time) { 
        Employee employee = employeeQueue.getFirst();

        employee.incrementTimeAtStation();

        if (employee.getTimeAtStation() > 0) {
            logAction(employee, time);
        }
    }

    /**
     * Logs the action of an employee working at the station.
     *
     * @param employee the employee performing the action
     * @param time     the current time tick
     */
    public void logAction(Employee employee, int time) 
    {
        System.out.println("(Tick " + time + ") " + employee.getName() +
                " (Employee) " + "has been working at " + name + " for " +
                employee.getTimeAtStation() + " tick" + (employee.getTimeAtStation() == 1 ? "" : "s") + ".");
    }

    /**
     * Logs the cleaning action of the station.
     */
    public void logCleaning() 
    {
        System.out.println(name + " is being cleaned.");

        isCleaned = true;
    }

    /**
     * Logs the prepping action of the station.
     */
    public void logPrepping()
    {
        System.out.println(name + " is being prepped.");

        isPrepped = true;
    }

    //Getters
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

    /**
     * Gets the queue of employees working at this station.
     *
     * @return the queue of employees
     */
    public LinkedList<Employee> getEmployeeQueue() {
        return employeeQueue;
    }

     /**
     * Checks if the station is cleaned.
     *
     * @return true if the station is cleaned, false otherwise
     */
    public boolean getIsCleaned() {
        return isCleaned;
    }

    /**
     * Checks if the station is prepped.
     *
     * @return true if the station is prepped, false otherwise
     */
    public boolean getIsPrepped() {
        return isPrepped;
    }

    //Setters
    /**
     * Sets the cleaned status of the station.
     *
     * @param setting the cleaned status to set
     */
    public void setIsCleaned(boolean setting) {
        isCleaned = setting;
    }

    /**
     * Sets the prepped status of the station.
     *
     * @param setting the prepped status to set
     */
    public void setIsPrepped(boolean setting) {
        isPrepped = setting;
    }

}
