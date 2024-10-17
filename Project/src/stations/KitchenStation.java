package stations;

import people.Employee;

import java.util.LinkedList;

/**
 * Represents a station in the kitchen where employees work.
 * Each station has a name, precedence, and a specific duration of use.
 */
public abstract class KitchenStation {
    private final LinkedList<Employee> employeeQueue;

    private final String name;

    private final int precedence; // Ensures ordering of stations

    private final int useDuration;

    /**
     * Default constructor for KitchenStation.
     * Initializes the employee queue and sets default values.
     */
    public KitchenStation() {
        employeeQueue = new LinkedList<Employee>();

        name = "";

        precedence = 0;

        useDuration = 0;
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

    /**
     * Simulates an employee using the station at a specific time.
     * The employee's time spent at the station is incremented and displayed.
     *
     * @param time the current time tick
     */
    public void useStation(int time) {
        Employee employee = employeeQueue.getFirst();

        employee.incrementTimeAtStation();

        int timeAtStation = employee.getTimeAtStation();

        if (timeAtStation > 0) {
            System.out.println("(Tick " + time + ") " + employee.getName() +
                    " (Employee) " + "has been working at " + name + " for " +
                    timeAtStation + " tick" + (timeAtStation == 1 ? "" : "s") + ".");
        }
    }
}