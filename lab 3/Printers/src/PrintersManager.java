import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintersManager
{
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    Queue<Printer> printersAvailevable = new LinkedList<Printer>();
    Random rand = new Random();

    PrintersManager(int count)
    {
        for(int i = 0; i < count; i++)
        {

            printersAvailevable.add(new Printer());
        }
    }

    public Printer takePrinter() throws InterruptedException
    {
        lock.lock();
        try
        {
            while (printersAvailevable.isEmpty()) notEmpty.await();
            return printersAvailevable.remove();
        }
        finally
        {
            lock.unlock();
        }
    }

    public void returnPrinter(Printer printer) throws InterruptedException
    {
        lock.lock();
        try
        {
            printersAvailevable.add(printer);
            notEmpty.signal();
        }
        finally
        {
            lock.unlock();
        }
    }
}
