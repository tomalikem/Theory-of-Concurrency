public class StringObject
{
    String phrase;
    int processingCount;

    StringObject(String phrase)
    {
        this.phrase = phrase;
        this.processingCount = 0;
    }

    public synchronized void process(String p, int orderNumber) throws InterruptedException
    {
        if(orderNumber != processingCount)
        {
            wait();
        }
        processingCount++;
        phrase = phrase + p;

        notify();
    }

    public synchronized String consume(int orderNumber) throws InterruptedException
    {
        if(orderNumber != processingCount)
        {
            wait();
        }
        notify();
        return phrase;
    }
}
