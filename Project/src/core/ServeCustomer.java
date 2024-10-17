package core;

import people.Customer;
import people.Employee;

interface ServeCustomer {
    void addCustomer(Customer customer);

    void addEarnings(double earnings);

    void addEmployee(Employee employee);

    void incrementCustomersServed();
}