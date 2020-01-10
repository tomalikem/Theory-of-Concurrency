import java.util.LinkedList;

public class Main
{
    public static void main(String[] args)
    {
        BoundedBuffer buffer = new BoundedBuffer();
        LinkedList<Thread> threads = new LinkedList<Thread>();
        for(int i = 0; i < 30; i ++)
        {
            threads.add(new Producer(buffer, i));
            threads.add(new Consumer(buffer, i));
        }
        for (Thread thread: threads)
        {
            thread.start();
        }

        for (Thread thread: threads)
        {
            try
            {
                thread.join();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
