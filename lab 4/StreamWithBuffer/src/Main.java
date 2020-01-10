import java.util.LinkedList;

public class Main
{
    public static void main(String[] args) {

        int processersCount = 5;
        int size = 100;
        LinkedList<Thread> threads = new LinkedList<>();

        int orderNumber = 0;

        Buffer buffer = new Buffer(size);

        Processer producer = new Processer(buffer, "C ", orderNumber);
        threads.add(producer);
        orderNumber++;

        for(int i = 0; i < processersCount; i++)
        {
            Processer processer = new Processer(buffer,"  " + i, orderNumber);
            threads.add(processer);
            orderNumber++;
        }

        Consumer consumer = new Consumer(buffer, orderNumber);
        threads.add(consumer);

        for(Thread thread: threads)
        {
            thread.start();
        }

        try
        {
            for(Thread thread: threads)
            {
                thread.join();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
