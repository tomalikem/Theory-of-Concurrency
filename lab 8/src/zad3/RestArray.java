package zad3;

import java.util.ArrayList;

public class RestArray
{
    ArrayList<Rest> array;
    RestArray(int size)
    {
        array = new ArrayList<>();
        for(int i = 0; i < size; i++)
        {
            array.add(new Rest());
        }
    }

    public ArrayList<Rest> getArrayList()
    {
        return array;
    }

    private int i = -1;
    public Integer getNextValue()
    {
        i++;
        return array.get(i%array.size()).getValue();
    }

    public Integer getValue(int x)
    {
        return array.get(x).getValue();
    }
}
