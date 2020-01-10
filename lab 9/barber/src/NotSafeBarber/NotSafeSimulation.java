package NotSafeBarber;

import ThreadSafeBarber.ThreadSafeBarber;

import java.util.LinkedList;

public class NotSafeSimulation
{
    NotSafeShop shop = new NotSafeShop(10);
    LinkedList<Thread> threads = new LinkedList<>();

    public void simulate(int customers, int barbers)
    {
        for(int i = 0; i < customers; i++)
        {
            threads.add(new NotSafeCustomer(shop, barbers * 2, i));
        }

        for(int i = 0; i < barbers; i++)
        {
            threads.add(new NotSafeBarber(this, shop, customers * 2, i));
        }

        for(Thread thread: threads)thread.start();

        try
        {
            for(Thread thread: threads)thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void killAll()
    {
        for (Thread thread: threads)
        {
            thread.interrupt();
        }
    }
}
