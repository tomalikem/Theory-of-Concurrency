import java.util.Random;

public class Table
{
    Random rand = new Random();

    public void eat(String text) throws InterruptedException
    {
        System.out.println(text + " started eating.");
        Thread.sleep(Math.abs(rand.nextInt()) % 10000 + 4000);
        System.out.println(text + " finished eating.");
    }
}
