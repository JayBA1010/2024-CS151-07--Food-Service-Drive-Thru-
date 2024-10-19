package menuItems;

/**
 * The Menu class represents a collection of food and beverage orders available 
 * in a drive-through simulation. It initializes a fixed set of menu items, 
 * allowing access to individual orders and their details.
 */
public class Menu {
    private Order[] orders = new Order[8];

    /**
     * Constructs a Menu instance with predefined order numbers and their
     * associated menu item
     */
    public Menu() {
        orders[0] = new FrenchFries();

        orders[1] = new FriedChicken();

        orders[2] = new GrilledChicken();

        orders[3] = new GrilledChickenSandwich();

        orders[4] = new Hamburger();

        orders[5] = new IceCream();

        orders[6] = new Salad();

        orders[7] = new Soda();
    }

    //Getters
    /**
     * Returns the FrenchFries order.
     *
     * @return the FrenchFries order
     */
    public FrenchFries getFrenchFries() {
        return (FrenchFries) orders[0];
    }

    /**
     * Returns the FriedChicken order.
     *
     * @return the FriedChicken order
     */
    public FriedChicken getFriedChicken() {
        return (FriedChicken) orders[1];
    }
    
    /**
     * Returns the GrilledChicken order.
     *
     * @return the GrilledChicken order
     */
    public GrilledChicken getGrilledChicken() {
        return (GrilledChicken) orders[2];
    }

    /**
     * Returns the GrilledChickenSandwich order.
     *
     * @return the GrilledChickenSandwich order
     */
    public GrilledChickenSandwich getGrilledChickenSandwich() {
        return (GrilledChickenSandwich) orders[3];
    }

    /**
     * Returns the Hamburger order.
     *
     * @return the Hamburger order
     */
    public Hamburger getHamburger() {
        return (Hamburger) orders[4];
    }

    /**
     * Returns the IceCream order.
     *
     * @return the IceCream order
     */
    public IceCream getIceCream() {
        return (IceCream) orders[5];
    }

    /**
     * Returns the order at the specified index.
     *
     * @param index the index of the order to retrieve
     * @return the Order at the specified index
     */
    public Order getOrder(int index) {
        return orders[index];
    }

    /**
     * Returns all orders in the menu.
     *
     * @return an array of all orders
     */
    public Order[] getOrders() {
        return orders;
    }
    
    /**
     * Returns the Salad order.
     *
     * @return the Salad order
     */
    public Salad getSalad() {
        return (Salad) orders[6];
    }
    
    /**
     * Returns the Soda order.
     *
     * @return the Soda order
     */
    public Soda getSoda() {
        return (Soda) orders[7];
    }


    //Setters
    /**
     * Sets the FrenchFries order.
     *
     * @param frenchFries the FrenchFries order to set
     */
    public void setFrenchFries(FrenchFries frenchFries) {
        orders[0] = frenchFries;
    }

    /**
     * Sets the FriedChicken order.
     *
     * @param friedChicken the FriedChicken order to set
     */
    public void setFriedChicken(FriedChicken friedChicken) {
        orders[1] = friedChicken;
    }

    /**
     * Sets the GrilledChicken order.
     *
     * @param grilledChicken the GrilledChicken order to set
     */
    public void setGrilledChicken(GrilledChicken grilledChicken) {
        orders[2] = grilledChicken;
    }

    /**
     * Sets the GrilledChickenSandwich order.
     *
     * @param grilledChickenSandwich the GrilledChickenSandwich order to set
     */
    public void setGrilledChickenSandwich(GrilledChickenSandwich grilledChickenSandwich) {
        orders[3] = grilledChickenSandwich;
    }

    /**
     * Sets the Hamburger order.
     *
     * @param hamburger the Hamburger order to set
     */
    public void setHamburger(Hamburger hamburger) {
        orders[4] = hamburger;
    }

    /**
     * Sets the IceCream order.
     *
     * @param iceCream the IceCream order to set
     */
    public void setIceCream(IceCream iceCream) {
        orders[5] = iceCream;
    }

    /**
     * Sets the orders for the menu.
     *
     * @param orders the array of orders to set
     */
    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    /**
     * Sets the Salad order.
     *
     * @param salad the Salad order to set
     */
    public void setSalad(Salad salad) {
        orders[6] = salad;
    }

    /**
     * Sets the Soda order.
     *
     * @param soda the Soda order to set
     */
    public void setSoda(Soda soda) {
        orders[7] = soda;
    }

    /**
     * Converts the menu orders to an array of strings for display purposes.
     *
     * @return an array of strings representing the names and prices of the orders
     */
    public String[] toStringArray() {
        String[] stringArray = new String[8];

        for (int i = 0; i < orders.length; i++) {
            stringArray[i] = orders[i].getName() + " ($" + orders[i].getPrice() + ")";
        }

        return stringArray;
    }
}
