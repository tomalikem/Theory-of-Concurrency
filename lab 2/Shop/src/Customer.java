import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Customer implements Runnable
{
    private Shop shop;
    private int customerNumber;
    private Random rand;

    Customer(Shop shop, int customerNumber, Random rand)
    {
        this.shop = shop;
        this.customerNumber = customerNumber;
        this.rand = rand;
    }

    public void run()
    {
        try
        {
            Bucket bucket = shop.takeBucket();
            System.out.println("Customer " + customerNumber + " started shopping with bucket " + bucket.getNumber());

            long sleepTime = Math.abs(rand.nextInt() % 100);
            Thread.sleep(sleepTime);

            shop.putBucket(bucket);
            System.out.println("Customer " + customerNumber + " finished shopping in " + sleepTime + " miliseconds.");
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
