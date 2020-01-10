public class Producer extends Thread
{
    BoundedBuffer buffer;
    int number;
    Producer(BoundedBuffer buffer, int number)
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
                buffer.put("Word: " + String.valueOf(i) + " by producer: " + String.valueOf(number));
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
