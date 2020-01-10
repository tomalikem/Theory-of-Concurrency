public class Consumer extends Thread
{
    Buffer buffer;
    int processingCount;

    Consumer(Buffer buffer, int processingCount)
    {
        this.buffer = buffer;
        this.processingCount = processingCount;
    }

    public void run()
    {
        try
        {
            for(int i = 0; i < buffer.size; i++)
            {
                System.out.println(buffer.consume(i, processingCount));
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
