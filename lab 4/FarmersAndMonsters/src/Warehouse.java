import java.util.LinkedList;

public  abstract class Warehouse
{
    protected int capacity;
    protected LinkedList<Object> food = new LinkedList<>();

    public Warehouse(int capacity)
    {
        this.capacity = capacity;
        for(int i = 0; i < capacity / 2; i++)
            food.add(new Object());
    }

    abstract public boolean canStore(int amount);
    abstract public boolean canEat(int amount);

    public void eat(int amount)
    {

        while(amount > 0)
        {
            food.remove();
            amount --;
        }
    }

    public void store(int amount)
    {
        while(amount > 0)
        {
            food.add(new Object());
            amount--;
        }
    }

    protected int inStock()
    {
        return food.size();
    }

}
