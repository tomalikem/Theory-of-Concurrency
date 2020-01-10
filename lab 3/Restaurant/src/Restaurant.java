import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant
{
    final Lock lock = new ReentrantLock();
    final Condition notEmpty = lock.newCondition();
    Queue<Table> tablesAvailable = new LinkedList<Table>();

    Restaurant(int count)
    {
        for(int i = 0; i < count; i++)
        {

            tablesAvailable.add(new Table());
        }
    }

    public Table orderTable() throws InterruptedException
    {
        lock.lock();
        try
        {
            while (tablesAvailable.isEmpty()) notEmpty.await();
            return tablesAvailable.remove();
        }
        finally
        {
            lock.unlock();
        }
    }

    public void returnTable(Table table) throws InterruptedException
    {
        lock.lock();
        try
        {
            tablesAvailable.add(table);
            notEmpty.signal();
        }
        finally
        {
            lock.unlock();
        }
    }
}
