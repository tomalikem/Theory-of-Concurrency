package ThreadSafeBarberManyQueues;

import java.util.LinkedList;

public class Simulation
{
    public static void main(String[] args) {
        simulate(20, 2);
    }

    public static void simulate(int customers, int barbers)
    {

        LinkedList<Thread> threads = new LinkedList<>();
        LinkedList<Barber> barbersList = new LinkedList<>();

        for(int i = 0; i < barbers; i++)
        {
            barbersList.add(new Barber(customers * 2, i));
        }
        Shop shop = new Shop(10, barbersList);

        for(int i = 0; i < customers; i++)
        {
            threads.add(new Customer(shop, barbers * 2, i));
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
