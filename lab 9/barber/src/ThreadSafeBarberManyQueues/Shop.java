package ThreadSafeBarberManyQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shop
{
    private int customerQueueSize;
    private Queue<Customer> sleepingCustomers;
    LinkedList<Barber> barbers;

    public Shop(int size, LinkedList<Barber> barbers)
    {
        customerQueueSize = size;
        sleepingCustomers = new LinkedList<>();
        this.barbers = barbers;
    }


    public boolean canSit()
    {
        return customerQueueSize >= sleepingCustomers.size();
    }

    public void addCustomer(Customer customer) throws InterruptedException
    {
        for(Barber barber: barbers)
        {
            if(barber.queue.canSit())
            {
                barber.queue.addCustomer(customer);
                break;
            }
        }
        customer.giveUp();
    }
}
