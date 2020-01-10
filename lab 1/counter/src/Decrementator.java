public class Decrementator extends Thread
{
    Counter counter;
    Decrementator(Counter counter)
    {
        this.counter = counter;
    }
    public void run()
    {
        for(int i = 0; i < 1000000000; i++)
        {
            counter.dec();
        }
    }
}
