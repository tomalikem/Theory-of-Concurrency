public class StarvingPhilosopher extends Philosopher
{
    Table table;
    public StarvingPhilosopher(int number, Fork f1, Fork f2, Table table)
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
            while(f1.isTaken() || f2.isTaken())
            {
                table.waits = true;
                table.wait();
            }
            consume(f1,f2);
            if(table.waits)
            {
                table.waits = false;
                table.notifyAll();
            }
        }
    }
}
