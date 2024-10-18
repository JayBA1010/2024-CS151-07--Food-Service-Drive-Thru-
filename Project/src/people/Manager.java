package people;

import core.DriveThrough;

import menuItems.FrenchFries;

import menuItems.FriedChicken;

import menuItems.GrilledChicken;

import menuItems.GrilledChickenSandwich;

import menuItems.Hamburger;

import menuItems.IceCream;

import menuItems.Salad;

import menuItems.Soda;

public class Manager extends Person
{
    public Manager(DriveThrough driveThrough, String name)
    {
        super(driveThrough, name);
    }

    public void updateFrenchFriesPrice(double newPrice) {
        driveThrough.getMenu().setFrenchFries(new FrenchFries(newPrice));
    }

    public void updateFriedChickenPrice(double newPrice) {
        driveThrough.getMenu().setFriedChicken(new FriedChicken(newPrice));
    }

    public void updateGrilledChickenPrice(double newPrice) {
        driveThrough.getMenu().setGrilledChicken(new GrilledChicken(newPrice));
    }

    public void updateGrilledChickenSandwichPrice(double newPrice) {
        driveThrough.getMenu().setGrilledChickenSandwich(new GrilledChickenSandwich(newPrice));
    }

    public void updateHamburgerPrice(double newPrice) {
        driveThrough.getMenu().setHamburger(new Hamburger(newPrice));
    }

    public void updateIceCreamPrice(double newPrice) {
        driveThrough.getMenu().setIceCream(new IceCream(newPrice));
    }

    public void updateSaladPrice(double newPrice) {
        driveThrough.getMenu().setSalad(new Salad(newPrice));
    }

    public void updateSodaPrice(double newPrice) {
        driveThrough.getMenu().setSoda(new Soda(newPrice));
    }
}
