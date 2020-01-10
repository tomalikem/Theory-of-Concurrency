public class SynCounter {

    int incCounter;
    int decCounter;

    Object o1 = new Object();
    Object o2 = new Object();

    SynCounter()
    {
        incCounter = 0;
        decCounter = 0;
    }

    void inc()
    {
        synchronized (o1)
        {
            incCounter++;
        }
    }

    void dec()
    {
        synchronized (o2)
        {
            decCounter--;
        }
    }

    int getCounter()
    {

        synchronized (o1)
        {
            synchronized (o2)
            {
                return incCounter + decCounter;
            }
        }
    }

}
