package core;

import static org.junit.Assert.*;
import org.junit.*;

import menuItems.Menu;
import people.Customer;
import people.Employee;
import people.Manager;

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
