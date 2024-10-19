package core;

import static org.junit.Assert.*;

import menuItems.*;
import org.junit.*;

import menuItems.Menu;
import people.Customer;
import people.Employee;
import people.Manager;
import stations.KitchenStation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CoreTests {

    private DriveThrough driveThrough;
    private Manager manager;
    private Customer customer;
    private Employee employee;

    @Before
    public void setUp() {
        driveThrough = new DriveThrough();
        manager = new Manager(driveThrough, "John Doe");
        customer = new Customer(driveThrough, "Jane Doe", driveThrough.getMenu().getOrder(0));
        employee = new Employee(driveThrough, "Employee1");
    }

    @Test
    public void autoSimulator() {
        DriveThrough driveThrough = new DriveThrough();
        List<Customer> customers = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        List<Manager> managers = new ArrayList<>();
        int numberOfInstances = 1000;

        for (int i = 0; i < numberOfInstances; i++) {
            driveThrough.addCustomer(new Customer(driveThrough, "Customer" + i, new FrenchFries()));
            customers.add(customer);
        }
        assertEquals(numberOfInstances, driveThrough.getOrderingStation().getCustomerQueue().size());

        for (int i = 0; i < numberOfInstances; i++) {
            driveThrough.addEmployee(new Employee(driveThrough, "Employee" + i));
            employees.add(employee);
        }
        assertEquals(numberOfInstances, driveThrough.getOrderingStation().getEmployeeQueue().size());

        for (int i = 0; i < numberOfInstances; i++) {
            managers.add(manager);
        }
        assertEquals(numberOfInstances, managers.size());

        for (Customer customer : customers) {
            assertNotNull(customer);
        }
        for (Employee employee : employees) {
            assertNotNull(employee);
        }
        for (Manager manager : managers) {
            assertNotNull(manager);
        }

        for (int time = 0; time < 5000; time++) {
            // Like a wave, it does something to a station then moves on to the next
            for (KitchenStation kitchenStation : driveThrough.getKitchenStations()) {
                // Checks if an employee is at the current station
                if (kitchenStation.hasEmployee()) {
                    // True -> Increment timeAtStation
                    kitchenStation.useStation(time);

                    LinkedList<Employee> employeeQueue = kitchenStation.getEmployeeQueue();

                    if (employeeQueue.getFirst().getTimeAtStation() == kitchenStation.getUseDuration()) {
                        employeeQueue.getFirst().changeKitchenStation(time);
                    }
                }
            }
        }

        System.out.println();

        System.out.println("Simulation Summary");

        System.out.println();

        System.out.println("Total customers attempted: " + driveThrough.getTotalCustomersAttempted());
        System.out.println("Customers served: " + driveThrough.getCustomersServed());

        int remaining = driveThrough.getTotalCustomersAttempted() - driveThrough.getCustomersServed();

        System.out.println("Customers still waiting: " + remaining);

        System.out.println("Total earnings: " + Main.round(driveThrough.getEarnings(), 2));

        assertEquals(driveThrough.getCustomersServed() * 4.99, driveThrough.getEarnings(), 1);
    }

    @Test
    public void testAddCustomer() {
        int initialQueueSize = driveThrough.getOrderingStation().getCustomerQueue().size();
        driveThrough.addCustomer(customer);
        assertEquals(initialQueueSize + 1, driveThrough.getOrderingStation().getCustomerQueue().size());
        assertEquals(1, driveThrough.getTotalCustomersAttempted());
    }

    @Test
    public void testAddEmployee() {
        int initialQueueSize = driveThrough.getOrderingStation().getEmployeeQueue().size();
        driveThrough.addEmployee(employee);
        assertEquals(initialQueueSize + 1, driveThrough.getOrderingStation().getEmployeeQueue().size());
        assertSame(driveThrough, employee.getDriveThrough());
    }

    @Test
    public void testAddEarnings() {
        double initialEarnings = driveThrough.getEarnings();
        driveThrough.addEarnings(100.50);
        assertEquals(initialEarnings + 100.50, driveThrough.getEarnings(), 0.01);
    }

    @Test
    public void testIncrementCustomersServed() {
        int initialServed = driveThrough.getCustomersServed();
        driveThrough.incrementCustomersServed();
        assertEquals(initialServed + 1, driveThrough.getCustomersServed());
    }

    @Test
    public void testSetAndGetManager() {
        driveThrough.setManager(manager);
        assertEquals(manager, driveThrough.getManager());
    }

    @Test
    public void testSetAndGetMenu() {
        Menu newMenu = new Menu();
        driveThrough.setMenu(newMenu);
        assertEquals(newMenu, driveThrough.getMenu());
    }
}
