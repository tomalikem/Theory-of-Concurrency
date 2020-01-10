package zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Pattern;
public class WordCounter
{
    public static void main(String[] args)
    {
        try
        {
            String filename = "D:\\Projects\\semestr 5\\Teoria Współbierzności\\lab 8\\src\\zad1\\loremIpsum.txt";
            long wordCount;

            long startTime, endTime, multiTime, singleTime;
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            startTime = System.currentTimeMillis();
            wordCount = reader.lines().parallel().flatMap(Pattern.compile(" ")::splitAsStream).filter(x -> x != "").count();
            endTime = System.currentTimeMillis();
            multiTime = endTime - startTime;

            reader = new BufferedReader(new FileReader(filename));
            startTime = System.currentTimeMillis();
            wordCount = reader.lines().flatMap(Pattern.compile(" ")::splitAsStream).filter(x -> x != "").count();
            endTime = System.currentTimeMillis();
            singleTime = endTime - startTime;

            System.out.println("Single: " + singleTime + " Multi: " +  multiTime);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
