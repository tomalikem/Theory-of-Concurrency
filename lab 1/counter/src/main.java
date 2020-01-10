import java.time.LocalTime;

public class main
{
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        SynCounter counter2 = new SynCounter();

        Decrementator dec = new Decrementator(counter1);
        Incrementator inc = new Incrementator(counter1);

        SynDecrementator synDec = new SynDecrementator(counter2);
        SynIncrementator synInc = new SynIncrementator(counter2);




        long startTime = System.currentTimeMillis();
        inc.start();
        dec.start();
        inc.join();
        dec.join();
        long endTime = System.currentTimeMillis();

        long startSynTime = System.currentTimeMillis();
        synInc.start();
        synDec.start();
        synInc.join();
        synDec.join();
        long endSynTime = System.currentTimeMillis();


        System.out.println(counter1.getCounter());
        System.out.println(endTime - startTime);
        System.out.println(counter2.getCounter());
        System.out.println(endSynTime - startSynTime);
    }
}
