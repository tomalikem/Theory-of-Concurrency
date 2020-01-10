public class Consumer extends Thread
{
    BoundedBuffer buffer;
    int number;
    Consumer(BoundedBuffer buffer, int number)
    {
        this.buffer = buffer;
        this.number = number;
    }
    public void run()
    {
        for(int i = 0; i < 10; i ++)
        {
            try
            {
                System.out.println("Consumer " + String.valueOf(number) + " consumed " + buffer.take());
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
