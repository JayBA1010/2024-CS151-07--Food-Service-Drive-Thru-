package people;

abstract class Person // convertible into interface
{
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}