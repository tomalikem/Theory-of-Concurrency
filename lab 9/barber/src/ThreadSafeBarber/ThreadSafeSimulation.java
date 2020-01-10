package ThreadSafeBarber;

import ThreadSafeBarber.ThreadSafeBarber;

import java.util.LinkedList;

public class ThreadSafeSimulation
{
    public static void main(String[] args) {
        simulate(20, 2);
    }

    public static void simulate(int customers, int barbers)
    {

        ThreadSafeShop shop = new ThreadSafeShop(10);
        LinkedList<Thread> threads = new LinkedList<>();

        for(int i = 0; i < customers; i++)
        {
            threads.add(new ThreadSafeCustomer(shop, barbers * 2, i));
        }

        for(int i = 0; i < barbers; i++)
        {
            threads.add(new ThreadSafeBarber(shop, customers * 2, i));
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
}
