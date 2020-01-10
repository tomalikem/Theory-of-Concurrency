package zad1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class IpsumReader
{
    public static String read(String filename)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String text = "";
            String line = reader.readLine();
            while (line!=null)
            {
                text = text + line + "\n";
                line = reader.readLine();
            }
            reader.close();
            return text;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
