package ThreadSafeBarber;

import ThreadSafeBarber.ThreadSafeCustomer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeShop
{
    private int customerQueueSize;
    private Queue<ThreadSafeCustomer> sleepingCustomers;
    private Integer waitingBarbersCount = 0;
    private Lock barberAwaits = new ReentrantLock();

    public ThreadSafeShop(int size)
    {
        customerQueueSize = size;
        sleepingCustomers = new LinkedList<>();
    }

    Lock customerQueueLock = new ReentrantLock();
    public boolean customerIsWaiting()
    {
        return sleepingCustomers.size() > 0;
    }

    public ThreadSafeCustomer getCustomer() throws InterruptedException
    {
        synchronized (sleepingCustomers)
        {
            if (!customerIsWaiting())
            {
                synchronized (waitingBarbersCount){waitingBarbersCount ++;}
                sleepingCustomers.wait();
            }
            ThreadSafeCustomer customer = sleepingCustomers.remove();
            return customer;
        }
    }

    public boolean canSit()
    {
        return customerQueueSize >= sleepingCustomers.size();
    }

    public void addCustomer(ThreadSafeCustomer customer)
    {
        synchronized (sleepingCustomers)
        {
            this.sleepingCustomers.add(customer);
            synchronized (waitingBarbersCount)
            {
                if(waitingBarbersCount > 0)
                {
                    waitingBarbersCount --;
                    sleepingCustomers.notify();
                }
            }
        }
    }
}
