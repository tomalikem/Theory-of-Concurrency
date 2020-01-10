import java.util.ArrayList;

public class Buffer
{
    ArrayList<StringObject> array = new ArrayList<>();
    int size;
    Buffer(int size)
    {
        this.size = size;
        for(int i = 0; i < size; i++)
        {
            array.add(new StringObject(("")));
        }
    }

    public void process(int i, String phrase, int orderNumber) throws InterruptedException
    {
        array.get(i).process(phrase, orderNumber);
    }

    public String consume(int i, int processingCount) throws InterruptedException
    {
        return array.get(i).consume(processingCount);
    }
}
