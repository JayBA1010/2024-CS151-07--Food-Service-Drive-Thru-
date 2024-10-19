package people;

/**
 * Represents the operations for serving customers in a drive-through system.
 * This interface defines methods for managing customers, employees, and earnings.
 */
public interface ServeCustomer {
    void addCustomer(Customer customer);

    void addEarnings(double earnings);

    void addEmployee(Employee employee);

    void incrementCustomersServed();
}
