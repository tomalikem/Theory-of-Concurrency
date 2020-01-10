import java.util.LinkedList;

public class Main
{
    public static void main(String[] args)
    {
        int printersCount = 20;
        int writersCount = 100;
        PrintersManager manager = new PrintersManager(printersCount);
        LinkedList<Thread> threads = new LinkedList<>();

        for(int i = 0; i< writersCount; i++) threads.add(new Writer(manager, i));
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
