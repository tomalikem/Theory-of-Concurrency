public class AsymetricPhilosopher extends Philosopher
{
    public AsymetricPhilosopher(int number, Fork f1, Fork f2)
    {
        this.number = number;
        this.f1 = f1;
        this.f2 = f2;
    }

    protected void eat() throws InterruptedException
    {
        if(number % 2 == 0)
        {
            consume(f1, f2);
        }
        else
        {
            consume(f2, f1);
        }
    }
}
