public class Incrementator extends Thread
{
    Counter counter;
    Incrementator(Counter counter)
    {
        this.counter = counter;
    }
    public void run()
    {
        for(int i = 0; i < 1000000000; i++)
        {
            counter.inc();
        }
    }
}
