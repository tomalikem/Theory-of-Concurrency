import java.util.LinkedList;

public class Simulation
{
    LinkedList<Philosopher> philosophers;

    Simulation(LinkedList<Philosopher> philosophers)
    {
        this.philosophers = philosophers;
    }

    long average = 0;
    long max = 0;
    long min = Long.MAX_VALUE;

    public String simulate()
    {
        String result = "";
        try
        {
            for(Philosopher philosopher: philosophers)
            {
                philosopher.start();
            }
            for(Philosopher philosopher: philosophers)
            {
                philosopher.join();
            }
            for(Philosopher philosopher: philosophers)
            {
                long time = philosopher.waitingTime/philosopher.waitingCount;
                average = average + time / philosophers.size();
                max = Math.max(max, time);
                min = Math.min(min, time);
            }
            result = average + "";
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
