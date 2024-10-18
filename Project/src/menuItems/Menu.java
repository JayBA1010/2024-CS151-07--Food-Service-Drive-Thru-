package menuItems;

public class Menu
{
    private Order[] orders = new Order[8];

    public Menu()
    {
        orders[0] = new FrenchFries();

        orders[1] = new FriedChicken();

        orders[2] = new GrilledChicken();

        orders[3] = new GrilledChickenSandwich();

        orders[4] = new Hamburger();

        orders[5] = new IceCream();

        orders[6] = new Salad();

        orders[7] = new Soda();
    }

    public FrenchFries getFrenchFries()
    {
        return (FrenchFries) orders[0];
    }

    public FriedChicken getFriedChicken()
    {
        return (FriedChicken) orders[1];
    }

    public GrilledChicken getGrilledChicken()
    {
        return (GrilledChicken) orders[2];
    }

    public GrilledChickenSandwich getGrilledChickenSandwich()
    {
        return (GrilledChickenSandwich) orders[3];
    }

    public Hamburger getHamburger()
    {
        return (Hamburger) orders[4];
    }

    public IceCream getIceCream()
    {
        return (IceCream) orders[5];
    }

    public Order getOrder(int index)
    {
        return orders[index];
    }

    public Order[] getOrders()
    {
        return orders;
    }

    public Salad getSalad()
    {
        return (Salad) orders[6];
    }

    public Soda getSoda()
    {
        return (Soda) orders[7];
    }

    public void setFrenchFries(FrenchFries frenchFries)
    {
        orders[0] = frenchFries;
    }

    public void setFriedChicken(FriedChicken friedChicken)
    {
        orders[1] = friedChicken;
    }

    public void setGrilledChicken(GrilledChicken grilledChicken)
    {
        orders[2] = grilledChicken;
    }

    public void setGrilledChickenSandwich(GrilledChickenSandwich grilledChickenSandwich)
    {
        orders[3] = grilledChickenSandwich;
    }

    public void setHamburger(Hamburger hamburger)
    {
        orders[4] = hamburger;
    }

    public void setIceCream(IceCream iceCream)
    {
        orders[5] = iceCream;
    }

    public void setOrders(Order[] orders)
    {
        this.orders = orders;
    }

    public void setSalad(Salad salad)
    {
        orders[6] = salad;
    }

    public void setSoda(Soda soda)
    {
        orders[7] = soda;
    }

    public String[] toStringArray()
    {
        String[] stringArray = new String[8];

        for(int i = 0; i < orders.length; i++)
        {
            stringArray[i] = orders[i].getName() + " ($" + orders[i].getPrice() + ")";
        }
        
        return stringArray;
    }


}