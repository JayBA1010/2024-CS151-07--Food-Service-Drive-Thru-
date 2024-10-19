package people;

import core.DriveThrough;
import menuItems.*;

/**
 * Represents a manager in a drive-through system.
 * The manager has the ability to update the prices of various menu items.
 */
public class Manager extends Person {
    /**
     * Constructs a new Manager with the given name and drive-through system.
     *
     * @param driveThrough the drive-through system where the manager works
     * @param name        the name of the manager
     */
    public Manager(DriveThrough driveThrough, String name) {
        super(driveThrough, name);
    }

    /**
     * Updates the price of French Fries in the menu.
     *
     * @param newPrice the new price for French Fries
     */
    public void updateFrenchFriesPrice(double newPrice) {
        driveThrough.getMenu().setFrenchFries(new FrenchFries(newPrice));
    }

    /**
     * Updates the price of Fried Chicken in the menu.
     *
     * @param newPrice the new price for Fried Chicken
     */
    public void updateFriedChickenPrice(double newPrice) {
        driveThrough.getMenu().setFriedChicken(new FriedChicken(newPrice));
    }

    /**
     * Updates the price of Grilled Chicken in the menu.
     *
     * @param newPrice the new price for Grilled Chicken
     */
    public void updateGrilledChickenPrice(double newPrice) {
        driveThrough.getMenu().setGrilledChicken(new GrilledChicken(newPrice));
    }

    /**
     * Updates the price of Grilled Chicken Sandwich in the menu.
     *
     * @param newPrice the new price for Grilled Chicken Sandwich
     */
    public void updateGrilledChickenSandwichPrice(double newPrice) {
        driveThrough.getMenu().setGrilledChickenSandwich(new GrilledChickenSandwich(newPrice));
    }

    /**
     * Updates the price of Hamburger in the menu.
     *
     * @param newPrice the new price for Hamburger
     */
    public void updateHamburgerPrice(double newPrice) {
        driveThrough.getMenu().setHamburger(new Hamburger(newPrice));
    }

    /**
     * Updates the price of Ice Cream in the menu.
     *
     * @param newPrice the new price for Ice Cream
     */
    public void updateIceCreamPrice(double newPrice) {
        driveThrough.getMenu().setIceCream(new IceCream(newPrice));
    }

    /**
     * Updates the price of Salad in the menu.
     *
     * @param newPrice the new price for Salad
     */
    public void updateSaladPrice(double newPrice) {
        driveThrough.getMenu().setSalad(new Salad(newPrice));
    }

    /**
     * Updates the price of Soda in the menu.
     *
     * @param newPrice the new price for Soda
     */
    public void updateSodaPrice(double newPrice) {
        driveThrough.getMenu().setSoda(new Soda(newPrice));
    }
}
