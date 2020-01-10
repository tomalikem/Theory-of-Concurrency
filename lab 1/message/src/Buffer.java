public class Buffer
{
    private String buffer;
    private boolean transfer = true;

    public synchronized void put(String msg)
    {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
            }
        }
        transfer = false;
        buffer = msg;
        notifyAll();
    }

    public synchronized  String take()
    {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
            }
        }
        transfer = true;

        notifyAll();
        return buffer;
    }
}
