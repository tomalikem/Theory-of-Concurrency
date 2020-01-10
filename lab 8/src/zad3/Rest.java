package zad3;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Rest
{
    private int delay;
    private int value;
    Rest()
    {
        Random rand = new Random();
        delay = Math.abs(rand.nextInt() % 100);
        value = Math.abs(rand.nextInt() % 1000);
    }

    public Integer getValue()
    {
        try
        {
            Thread.sleep(delay);
        }
        catch (InterruptedException e)
        {

        }
        return value;
    }

    public CompletableFuture<Integer> getFutureValue() {
        return CompletableFuture.supplyAsync( () -> {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return value;
        });
    }
}
