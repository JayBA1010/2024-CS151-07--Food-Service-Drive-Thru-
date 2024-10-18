package menuItems;

public class Menu {
    private static FrenchFries frenchFries;
    private static FriedChicken friedChicken;
    private static GrilledChicken grilledChicken;
    private static GrilledChickenSandwich grilledChickenSandwich;
    private static Hamburger hamburger;
    private static IceCream iceCream;
    private static Salad salad;
    private static Soda soda;

    static {
        frenchFries = new FrenchFries();
        friedChicken = new FriedChicken();
        grilledChicken = new GrilledChicken();
        grilledChickenSandwich = new GrilledChickenSandwich();
        hamburger = new Hamburger();
        iceCream = new IceCream();
        salad = new Salad();
        soda = new Soda();
    }

    public static void updateFrenchFriesPrice(double newPrice) {
        frenchFries = new FrenchFries(newPrice);
    }

    public static void updateFriedChickenPrice(double newPrice) {
        friedChicken = new FriedChicken(newPrice);
    }

    public static void updateGrilledChickenPrice(double newPrice) {
        grilledChicken = new GrilledChicken(newPrice);
    }

    public static void updateGrilledChickenSandwichPrice(double newPrice) {
        grilledChickenSandwich = new GrilledChickenSandwich(newPrice);
    }

    public static void updateHamburgerPrice(double newPrice) {
        hamburger = new Hamburger(newPrice);
    }

    public static void updateIceCreamPrice(double newPrice) {
        iceCream = new IceCream(newPrice);
    }

    public static void updateSaladPrice(double newPrice) {
        salad = new Salad(newPrice);
    }

    public static void updateSodaPrice(double newPrice) {
        soda = new Soda(newPrice);
    }

    public static FrenchFries getFrenchFries() {
        return new FrenchFries(frenchFries.getPrice());
    }

    public static FriedChicken getFriedChicken() {
        return new FriedChicken(friedChicken.getPrice());
    }

    public static GrilledChicken getGrilledChicken() {
        return new GrilledChicken(grilledChicken.getPrice());
    }

    public static GrilledChickenSandwich getGrilledChickenSandwich() {
        return new GrilledChickenSandwich(grilledChickenSandwich.getPrice());
    }

    public static Hamburger getHamburger() {
        return new Hamburger(hamburger.getPrice());
    }

    public static IceCream getIceCream() {
        return new IceCream(iceCream.getPrice());
    }

    public static Salad getSalad() {
        return new Salad(salad.getPrice());
    }

    public static Soda getSoda() {
        return new Soda(soda.getPrice());
    }
}
