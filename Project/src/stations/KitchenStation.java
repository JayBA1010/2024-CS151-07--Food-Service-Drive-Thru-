package stations;

import people.Employee;

import java.util.LinkedList;

public abstract class KitchenStation {
    private final LinkedList<Employee> employeeQueue;

    private final String name;

    private final int precedence;

    private final int useDuration;

    public KitchenStation(String name, int precedence, int useDuration) {
        employeeQueue = new LinkedList<Employee>();

        this.name = name;

        this.precedence = precedence;

        this.useDuration = useDuration;
    }

    public LinkedList<Employee> getEmployeeQueue() {
        return employeeQueue;
    }

    public String getName() {
        return name;
    }

    public int getPrecedence() {
        return precedence;
    }

    public int getUseDuration() {
        return useDuration;
    }

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