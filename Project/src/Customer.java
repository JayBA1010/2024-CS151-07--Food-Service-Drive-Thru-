public class Customer extends Person
{
    Order order;

    public Customer(String name, String order)
    {
        super(name);

        switch(order)
        {
            case "French Fries":
                this.order = new FrenchFries();

                break;
            case "Fried Chicken":
                this.order = new FriedChicken();

                break;
            case "Grilled Chicken":
                this.order = new GrilledChicken();

                break;
            case "Grilled Chicken Sandwich":
                this.order = new GrilledChickenSandwich();

                break;
            case "Hamburger":
                this.order = new Hamburger();

                break;
            case "Ice Cream":
                this.order = new IceCream();

                break;
            case "Salad":
                this.order = new Salad();

                break;
            case "Soda":
                this.order = new Soda();
                
                break;
        }
    }
    
    public Order getOrder()
    {
        return order;
    }
}