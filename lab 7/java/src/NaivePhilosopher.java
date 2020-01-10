import java.util.Random;

public class NaivePhilosopher extends Philosopher
{
    public NaivePhilosopher(int number, Fork f1, Fork f2)
    {
        this.number = number;
        this.f1 = f1;
        this.f2 = f2;
    }

    protected void eat() throws InterruptedException
    {
        super.consume(f1, f2);
    }
}
