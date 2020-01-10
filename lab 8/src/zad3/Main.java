package zad3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> results;
        int size = 200;
        RestArray rest = new RestArray(size);
        long startTime, endTime, singleTime, futureTime;

        startTime = System.currentTimeMillis();
        results = getValuesWithFuture(size, rest);
        endTime = System.currentTimeMillis();
        futureTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        results = getValuesWithSingleThread(size, rest);
        endTime = System.currentTimeMillis();
        singleTime = endTime - startTime;

        System.out.println("futureTime: " + futureTime + " ms.");
        System.out.println("singleTime: " + singleTime + " ms.");

    }

    public static long getTime(long startTime, long endTime, List<Integer> results)
    {
        for(Integer result: results) System.out.print(result);
        System.out.println();
        return endTime - startTime;
    }


    public static List<Integer> getValuesWithFuture(int size, RestArray restArray)
    {
        Executor executor = Executors.newFixedThreadPool(200);

        List<CompletableFuture<Integer>> ll = IntStream.range(0, 200).mapToObj(l->
            CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get()
            {
                return restArray.getNextValue();
            }
        }, executor)).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        try {
            for (CompletableFuture<Integer> future: ll)
                result.add(future.get());
        }
        catch (Exception e)
        {

        }
        return result;
    }

    public static ArrayList<Integer> getValuesWithSingleThread(int size, RestArray rest)
    {
        try
        {
            ArrayList<Integer> values = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                values.add(rest.getValue(i));
            }
            return values;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
