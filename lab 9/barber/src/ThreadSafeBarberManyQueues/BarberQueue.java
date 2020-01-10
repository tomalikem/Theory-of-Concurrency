package ThreadSafeBarberManyQueues;

import java.util.LinkedList;
import java.util.Queue;

public class BarberQueue
{
    BarberQueue(int size)
    {
        this.size = size;
    }
    private int size;
    private Queue<Customer> sleepingCustomers = new LinkedList<>();
    public boolean barberAwaits = false;
    public Customer getCustomer() throws InterruptedException
    {
        synchronized (this)
        {
            if (!customerIsWaiting())
            {
                barberAwaits = true;
                sleepingCustomers.wait();
            }
            Customer customer = sleepingCustomers.remove();
            return customer;
        }
    }

    public void addCustomer(Customer customer)
    {
        synchronized (this)
        {
            this.sleepingCustomers.add(customer);
            if(barberAwaits)
            {
                barberAwaits = false;
                notify();
            }

        }
    }

    public boolean customerIsWaiting()
    {
        return sleepingCustomers.size() > 0;
    }

    public boolean canSit()
    {
        return size >= sleepingCustomers.size();
    }
}
