import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main
{
    public static void main(String[] args) throws Exception
    {

        long[][] times = new long[3][3];
        int height = 600;
        int width = 720;
        LinkedList<SetColor> setList = new LinkedList<>();
        int[] threadCounts = {1,4,8};
        long startTime;
        long endTime;
        for(int threads = 0; threads < 3; threads ++)
        {
            int threadCount = threadCounts[threads];
            startTime = System.currentTimeMillis();
            int[] vertical = {threadCount, 10 * threadCount, height};
            int[] horizontal = {1, 1, width};
            for(int parts = 0; parts < 3; parts ++)
            {
                int verticalParts = vertical[parts];
                int horizontalParts = horizontal[parts];

                ExecutorService executor = Executors.newFixedThreadPool(threadCount);


                int verticalDiff = height / verticalParts;
                int horizontalDiff = width / horizontalParts;



                LinkedList<Future<LinkedList<SetColor>>> setLists = new LinkedList<>();
                setList = new LinkedList<>();



                for(int i = 0; i < verticalParts; i++)
                {
                    for(int j = 0; j < horizontalParts; j++)
                    {
                        int y1 = i * verticalDiff;
                        int y2 = (i + 1) * verticalDiff;
                        int x1 = j * horizontalDiff;
                        int x2 = (j + 1) * horizontalDiff;
                        Callable<LinkedList<SetColor>> callable = new Task(y1, y2, x1, x2, width, height);
                        Future<LinkedList<SetColor>> future = executor.submit(callable);
                        setLists.add(future);
                    }
                }

                for(Future<LinkedList<SetColor>> futureList: setLists)
                {
                    setList.addAll(futureList.get());
                }
                endTime = System.currentTimeMillis();

                times[threads][parts] = endTime - startTime;
            }

        }

        Image I = new Image(100, 100, height, width);

        for(SetColor setColor: setList)
        {
            I.setRGB(setColor);
        }

        I.setVisible(true);

        System.out.println("Parts:     1x   10x   all");
        for(int i = 0 ; i < 3; i ++)
        {
            System.out.print("Threads: " + threadCounts[i] + " ");
            for(int j = 0; j < 3; j++)
            {
                System.out.print(times[i][j] + "  ");
            }
            System.out.println();
        }

    }
}
