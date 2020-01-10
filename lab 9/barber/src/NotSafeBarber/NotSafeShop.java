package NotSafeBarber;

import ThreadSafeBarber.ThreadSafeCustomer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotSafeShop
{
    private int customerQueueSize;
    private Queue<NotSafeCustomer> sleepingCustomers;
    private Integer waitingBarbersCount = 0;

    public NotSafeShop(int size)
    {
        customerQueueSize = size;
        sleepingCustomers = new LinkedList<>();
    }

    public boolean customerIsWaiting()
    {
        return sleepingCustomers.size() > 0;
    }

    public NotSafeCustomer getCustomer() throws InterruptedException
    {
        if (!customerIsWaiting())
        {
            waitingBarbersCount++;
            while(!customerIsWaiting())
            {
                Thread.sleep(10);
            }
        }
        NotSafeCustomer customer = sleepingCustomers.remove();
        return customer;

    }

    public boolean canSit()
    {
        return customerQueueSize >= sleepingCustomers.size();
    }

    public void addCustomer(NotSafeCustomer customer)
    {
        this.sleepingCustomers.add(customer);
        if(waitingBarbersCount > 0)
        {
            waitingBarbersCount --;
        }
    }
}
