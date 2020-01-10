public class Counter {
    int counter;

    Counter()
    {
        this.counter = 0;
    }

    int getCounter()
    {
        return counter;
    }

    void inc()
    {
        counter = counter + 1;
    }

    void dec()
    {
        counter = counter - 1;
    }
}
