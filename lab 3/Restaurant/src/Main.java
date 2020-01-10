import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random rand = new Random();

        int tableCount = 3;
        int groupCount = 20;
        int customerCount = 50;

        Restaurant restaurant = new Restaurant(tableCount);
        ArrayList<Group> groups = new ArrayList<>();
        LinkedList<Thread> threads = new LinkedList<>();

        for(int i = 0; i< groupCount; i++)groups.add(new Group(restaurant, i));

        for(int i = 0; i< customerCount; i++)
        {
            int groupNumber = Math.abs(rand.nextInt()) % groupCount;
            threads.add(new Customer(groups.get(groupNumber), i));
        }


        for (Thread thread : threads) thread.start();
        for (Thread thread : threads)
        {
            try
            {
                thread.join();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
