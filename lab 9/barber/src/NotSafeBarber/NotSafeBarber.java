package NotSafeBarber;

import ThreadSafeBarber.ThreadSafeCustomer;
import ThreadSafeBarber.ThreadSafeShop;

public class NotSafeBarber extends Thread
{
    private int number;
    private int count;
    NotSafeShop shop;
    NotSafeSimulation simulation;

    public NotSafeBarber(NotSafeSimulation simulation, NotSafeShop shop, int count, int number)
    {
        this.simulation = simulation;
        this.shop = shop;
        this.number = number;
        this.count = count;
    }

    public void run()
    {
        try
        {
            for(int i = 0; i< count; i++)
            {
                NotSafeCustomer customer = shop.getCustomer();
                cutHair(customer);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            simulation.killAll();
        }
    }

    public void cutHair(NotSafeCustomer customer) throws InterruptedException
    {
        Thread.sleep(10);
        customer.gotHaircut = true;
        System.out.println("Barber " + number + " finished cutting hair of customer " + customer.getNumber());
    }
}
