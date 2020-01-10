public class CountingSemaphore
{
    private int count;

    CountingSemaphore(int count)
    {
        this.count = count;
    }

    public synchronized void v()
    {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
            }

        }
        count--;
    }

    public synchronized void p()
    {
        count++;
        notify();
    }
}
