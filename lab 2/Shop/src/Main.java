import java.util.ArrayList;
import java.util.Random;


public class Main
{
    public static void main(String[] args)
    {
        int bucketCount = 10;
        int customerCount = 100;

        ArrayList<Thread> threads = new ArrayList<Thread>();
        Random rand = new Random();
        Shop shop = new Shop(bucketCount);

        for(int number = 0; number < customerCount; number++)
        {
            Thread customer = new Thread(new Customer(shop, number, rand));
            threads.add(customer);
        }

        for(Thread thread: threads)
        {
            thread.start();
        }

        for(Thread thread: threads)
        {
            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {
                System.out.print("Join failed");
            }
        }
    }
}
