public class SynDecrementator extends Thread
{
    SynCounter counter;
    SynDecrementator(SynCounter counter)
    {
        this.counter = counter;
    }
    public void run()
    {
        int count = 0;
        for(int i = 0; i < 100000000; i++)
        {
            counter.dec();
        }
    }
}
