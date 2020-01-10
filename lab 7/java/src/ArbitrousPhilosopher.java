public class ArbitrousPhilosopher extends Philosopher
{
    Table table;

    public ArbitrousPhilosopher(int number, Fork f1, Fork f2, Table table)
    {
        this.number = number;
        this.f1 = f1;
        this.f2 = f2;
        this.table = table;
    }

    protected void eat() throws InterruptedException
    {
        synchronized (table)
        {
            if(!table.canStartEating())
            {
                table.waits = true;
                wait();
            }
            table.startEating();
            consume(f1, f2);
            table.finishEating();
            if(table.waits)notify();
        }
    }
}
