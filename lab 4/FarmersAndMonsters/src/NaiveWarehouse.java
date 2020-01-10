import java.util.LinkedList;

public class NaiveWarehouse extends Warehouse
{

    public NaiveWarehouse(int capacity)
    {
        super(capacity);
    }

    public boolean canStore(int amount)
    {
        if(inStock() + amount <= capacity)return true;
        else return false;

    }

    public boolean canEat(int amount)
    {

        if(inStock() - amount > 0)return true;
        else return false;

    }
}
