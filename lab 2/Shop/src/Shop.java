import java.util.LinkedList;
import java.util.Queue;

public class Shop
{
    Queue<Bucket> queue = new LinkedList<>();
    CountingSemaphore semaphore;

    Shop(int bucketCount)
    {
        semaphore = new CountingSemaphore(bucketCount);
        for(int i = 0; i < bucketCount; i++)
        {
            queue.add(new Bucket(i));
        }
    }

    public Bucket takeBucket()
    {
        semaphore.v();
        synchronized (queue)
        {
            return queue.remove();
        }

    }

    public void putBucket(Bucket bucket)
    {
        synchronized (queue)
        {
            queue.add(bucket);
        }
        semaphore.p();
    }
}
