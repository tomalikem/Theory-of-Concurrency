import java.util.Random;

public class Printer
{
    Random rand = new Random();

    public void print(String text) throws InterruptedException
    {
        Thread.sleep(Math.abs(rand.nextInt()) % 10000);
        System.out.println(text);
    }
}
