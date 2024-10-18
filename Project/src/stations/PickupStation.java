package stations;

import core.DriveThrough;
import people.Customer;
import people.Employee;

public class PickupStation extends KitchenStation {
    public PickupStation() {
        super("Pickup Station", 4, 1);
    }

    @Override
    public void useStation(int time) {
        Employee employee = getEmployeeQueue().getFirst();

        if (employee.getTimeAtStation() == 0) {
            employee.fulfillOrder(time);
        }

        super.useStation(time);
    }
}