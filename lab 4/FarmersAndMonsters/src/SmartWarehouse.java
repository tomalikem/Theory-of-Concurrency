public class SmartWarehouse extends Warehouse
{
    public SmartWarehouse(int capacity)
    {
        super(capacity);
    }

    public boolean canStore(int amount)
    {
        if(inStock() + amount <= capacity && inStock() <= capacity / 2)return true;
        return false;

    }

    public boolean canEat(int amount)
    {
        if(inStock() - amount > 0 && inStock() >= capacity / 2)return true;
        return false;

    }
}
