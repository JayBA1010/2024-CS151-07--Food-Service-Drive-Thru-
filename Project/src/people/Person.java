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

    //Getters
    /**
     * Gets the drive-through associated with the person.
     *
     * @return the drive-through 
     */
    public DriveThrough getDriveThrough() {
        return driveThrough;
    }

    /**
     * Gets the name of the person.
     *
     * @return the person name
     */
    public String getName() {
        return name;
    }

    //Setters
    /**
     * Sets the drive-through associated with the person.
     *
     * @param driveThrough the drive-through to set
     */
    public void setDriveThrough(DriveThrough driveThrough) {
        this.driveThrough = driveThrough;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
