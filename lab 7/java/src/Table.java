public class Table
{
    private  int currentlyEating;
    private int size;
    public boolean waits = false;
    Table(int size)
    {
        this.currentlyEating = 0;
        this.size = size;
    }

    public boolean canStartEating()
    {
        return (currentlyEating < size);
    }

    public void startEating()
    {
        currentlyEating++;
    }

    public void finishEating()
    {
        currentlyEating--;
    }
}
