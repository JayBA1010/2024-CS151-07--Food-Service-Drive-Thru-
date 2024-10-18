package people;

/**
 * Represents a general person with a name.
 */
public abstract class Person {
    public String name;

    /**
     * Constructs a new Person with the given name.
     *
     * @param name the name of the person
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the person.
     *
     * @return the person name
     */
    public String getName() {
        return name;
    }
}