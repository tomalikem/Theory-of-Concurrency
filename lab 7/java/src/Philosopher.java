import java.util.Random;

public abstract class Philosopher extends Thread
{
    Random rand = new Random();
    int number;
    Fork f1;
    Fork f2;
    long waitingTime = 0;
    long waitingCount = 0;
    long startedWaiting;
    long finishedWaiting;

    public void run()
    {
        try
        {
            for(int i = 0; i < 100; i++)
            {
                think();
                startedWaiting = System.currentTimeMillis();
                eat();
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void think() throws InterruptedException
    {
        sleep(Math.abs(rand.nextInt()) % 100);
    }

    abstract protected void eat()  throws InterruptedException;

    protected void consume(Fork f1, Fork f2) throws InterruptedException
    {
        f1.take();
        sleep(1);
        f2.take();
        finishedWaiting = System.currentTimeMillis();
        waitingCount++;
        waitingTime = waitingTime + finishedWaiting - startedWaiting;
        sleep(Math.abs(rand.nextInt()) % 100);
        f1.putBack();
        f2.putBack();
    }
}
