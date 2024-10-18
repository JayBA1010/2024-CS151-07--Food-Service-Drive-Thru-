package people;

import core.DriveThrough;

/**
 * Represents a general person with a name.
 */
public abstract class Person {
    public DriveThrough driveThrough;
    public String name;

    /**
     * Constructs a new Person with the given name.
     *
     * @param name the name of the person
     */
    public Person(DriveThrough driveThrough, String name) {
        this.driveThrough = driveThrough;
        this.name = name;
    }

    public DriveThrough getDriveThrough()
    {
        return driveThrough;
    }

    public void setDriveThrough(DriveThrough driveThrough)
    {
        this.driveThrough = driveThrough;
    }

    /**
     * Gets the name of the person.
     *
     * @return the person name
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}