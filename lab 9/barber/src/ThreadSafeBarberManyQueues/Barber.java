package ThreadSafeBarberManyQueues;

public class Barber extends Thread
{
    public BarberQueue queue;
    private int number;
    private int count;

    public Barber(int count, int number)
    {
        this.number = number;
        this.count = count;
        queue = new BarberQueue(5);
    }

    public void run()
    {
        try
        {
            for(int i = 0; i< count; i++)
            {
                Customer customer = queue.getCustomer();
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

    public void cutHair(Customer customer) throws InterruptedException
    {
        Thread.sleep(1000);
        customer.notify();
        System.out.println("Barber " + number + " finished cutting hair of customer " + customer.getNumber());
    }
}
