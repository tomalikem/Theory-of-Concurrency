import java.util.ArrayList;
        import java.util.LinkedList;

public class Main
{
    public static void main(String[] args) {

        for(int N = 2; N < 10; N++)
        {
            LinkedList<Philosopher> philosophers = new LinkedList<>();
            ArrayList<Fork> forks = new ArrayList<>();

            for(int i = 0; i < N; i++)
            {
                forks.add(new Fork());
            }

            Table table = new Table(N-1);
            for(int i = 0; i < N; i++)
            {
                philosophers.add(new NaivePhilosopher(i, forks.get(i%N), forks.get((i+1)%N)));
            }

            Simulation simulation = new Simulation(philosophers);
            String result = simulation.simulate();
            System.out.println(result);
        }
    }
}
