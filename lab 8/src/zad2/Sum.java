package zad2;

import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<Integer>
{
    final int seqThreshold = 500;
    int[] data;
    int start, end;

    Sum(int[] data, int start, int end)
    {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute()
    {
        int sum = 0;
        if ((end - start) < seqThreshold)
        {
            for (int i = start; i < end; i++) sum += data[i];
        }
        else
        {
            int middle = (start + end) / 2;

            Sum subtaskA = new Sum(data, start, middle);
            Sum subtaskB = new Sum(data, middle, end);

            subtaskA.fork();
            subtaskB.fork();

            sum += subtaskA.join() + subtaskB.join();
        }
        return sum;
    }
}
