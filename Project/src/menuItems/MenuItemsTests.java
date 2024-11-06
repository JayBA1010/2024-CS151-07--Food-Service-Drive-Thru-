package menuItems;

//import static org.junit.Assert.*;
//import org.junit.*;

public class MenuItemsTests {

    private Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    // Test the default prices and item names in the Menu class
    @Test
    public void testMenuDefaultItems() {
        // Check French Fries
        assertEquals("French Fries", menu.getFrenchFries().getName());
        assertEquals(4.99, menu.getFrenchFries().getPrice(), 0.01);

        // Check Fried Chicken
        assertEquals("Fried Chicken", menu.getFriedChicken().getName());
        assertEquals(9.99, menu.getFriedChicken().getPrice(), 0.01);

        // Check Grilled Chicken
        assertEquals("Grilled Chicken", menu.getGrilledChicken().getName());
        assertEquals(14.99, menu.getGrilledChicken().getPrice(), 0.01);

        // Check Hamburger
        assertEquals("Hamburger", menu.getHamburger().getName());
        assertEquals(7.99, menu.getHamburger().getPrice(), 0.01);
    }

    // Test if custom prices are set correctly
    @Test
    public void testCustomPricesForOrders() {
        FrenchFries customFries = new FrenchFries(3.99);
        menu.setFrenchFries(customFries);
        assertEquals(3.99, menu.getFrenchFries().getPrice(), 0.01);

        GrilledChicken customChicken = new GrilledChicken(12.99);
        menu.setGrilledChicken(customChicken);
        assertEquals(12.99, menu.getGrilledChicken().getPrice(), 0.01);
    }

    // Test task lists of specific items
    @Test
    public void testOrderTasks() {
        // Check French Fries tasks
        assertTrue(menu.getFrenchFries().getTasks().contains("Frying Station"));

        // Check Grilled Chicken Sandwich tasks
        assertTrue(menu.getGrilledChickenSandwich().getTasks().contains("Grilling Station"));
        assertTrue(menu.getGrilledChickenSandwich().getTasks().contains("Prepping Station"));

        // Check Ice Cream tasks
        assertTrue(menu.getIceCream().getTasks().contains("Dessert Station"));
    }

    // Test if setting and retrieving orders works correctly
    @Test
    public void testSetAndGetOrder() {
        // Create a new custom Ice Cream order and set it in the menu
        IceCream customIceCream = new IceCream(5.99);
        menu.setIceCream(customIceCream);
        assertEquals(5.99, menu.getIceCream().getPrice(), 0.01);

        // Retrieve the custom Ice Cream order from the menu
        assertSame(customIceCream, menu.getIceCream());
    }

    // Test the toStringArray method for correct output formatting
    @Test
    public void testMenuToStringArray() {
        String[] menuStrings = menu.toStringArray();

        assertEquals("French Fries ($4.99)", menuStrings[0]);
        assertEquals("Fried Chicken ($9.99)", menuStrings[1]);
        assertEquals("Grilled Chicken ($14.99)", menuStrings[2]);
        assertEquals("Grilled Chicken Sandwich ($9.99)", menuStrings[3]);
        assertEquals("Hamburger ($7.99)", menuStrings[4]);
        assertEquals("Ice Cream ($3.99)", menuStrings[5]);
        assertEquals("Salad ($5.99)", menuStrings[6]);
        assertEquals("Soda ($2.49)", menuStrings[7]);
    }

    // Test if a default menu order can be retrieved by index
    @Test
    public void testGetOrderByIndex() {
        Order order = menu.getOrder(0); // French Fries
        assertEquals("French Fries", order.getName());
        assertEquals(4.99, order.getPrice(), 0.01);

        order = menu.getOrder(4); // Hamburger
        assertEquals("Hamburger", order.getName());
        assertEquals(7.99, order.getPrice(), 0.01);
    }

    // Test for modifying the entire order list
    @Test
    public void testSetEntireMenuOrders() {
        Order[] newOrders = new Order[] {
                new FrenchFries(5.99),
                new FriedChicken(10.99),
                new GrilledChicken(12.99),
                new GrilledChickenSandwich(11.99),
                new Hamburger(8.99),
                new IceCream(4.99),
                new Salad(6.99),
                new Soda(2.99)
        };

        menu.setOrders(newOrders);
        assertEquals(5.99, menu.getFrenchFries().getPrice(), 0.01);
        assertEquals(10.99, menu.getFriedChicken().getPrice(), 0.01);
        assertEquals(12.99, menu.getGrilledChicken().getPrice(), 0.01);
        assertEquals(11.99, menu.getGrilledChickenSandwich().getPrice(), 0.01);
        assertEquals(8.99, menu.getHamburger().getPrice(), 0.01);
        assertEquals(4.99, menu.getIceCream().getPrice(), 0.01);
        assertEquals(6.99, menu.getSalad().getPrice(), 0.01);
        assertEquals(2.99, menu.getSoda().getPrice(), 0.01);
    }
}
