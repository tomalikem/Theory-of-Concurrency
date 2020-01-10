package ThreadSafeBarber;

public class ThreadSafeBarber extends Thread
{
    private int number;
    private int count;
    ThreadSafeShop shop;

    public ThreadSafeBarber(ThreadSafeShop shop, int count, int number)
    {
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
                ThreadSafeCustomer customer = shop.getCustomer();
                synchronized (customer)
                {
                    customer.notify();
                    cutHair(customer);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void cutHair(ThreadSafeCustomer customer) throws InterruptedException
    {
        Thread.sleep(1000);
        customer.notify();
        System.out.println("Barber " + number + " finished cutting hair of customer " + customer.getNumber());
    }
}
