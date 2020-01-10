package zad2;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        ForkJoinPool fjp = new ForkJoinPool();

        int[] nums = new int[10000000];
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = rand.nextInt();
        }
        Sum task = new Sum(nums, 0, nums.length);

        Long startTime = System.currentTimeMillis();
        int sum = fjp.invoke(task);
        Long endTime = System.currentTimeMillis();
        System.out.println("Sum: " + sum + " time: " + (endTime - startTime) + " ms");
    }
}
