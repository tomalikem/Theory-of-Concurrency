package zad1;
import java.io.*;
import java.util.Random;

public class AddSpaces
{
    public static void main(String[] args)
    {
        try
        {
            String filename = "D:\\Projects\\semestr 5\\Teoria Współbierzności\\lab 8\\src\\zad1\\loremIpsum.txt";
            Random rand = new Random();
            String text = IpsumReader.read(filename);
            String[] array = text.split("r");
            int length = array.length;
            for(int i = 0; i < 100; i++)
            {
                int r = Math.abs(rand.nextInt()) % length;
                array[r] += "  ";
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for(int i = 0; i < length; i++)
            {
                writer.write(array[i]);
            }
            writer.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
