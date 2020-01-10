public class Processer extends Thread
{
    Buffer buffer;
    String phrase;
    int processCounter;
    int counter;

    Processer(Buffer buffer, String phrase, int processCounter)
    {
        this.buffer = buffer;
        this.phrase = phrase;
        this .processCounter = processCounter;
        this.counter = 0;
    }

    public void run()
    {
        try
        {
            for(int i = 0; i < buffer.size; i++)
            {
                buffer.process(i, phrase, processCounter);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
