public class Group
{

    private Restaurant restaurant;
    private int number;
    private int memberCount = 0;
    private int presentCount = 0;
    private Table table;

    Group(Restaurant restaurant, int number)
    {
        this.restaurant = restaurant;
        this.number = number;
    }

    public synchronized void addMember()
    {
        memberCount ++;
    }

    public synchronized Table orderTable() throws InterruptedException
    {
        presentCount++;

        if(presentCount == memberCount)
        {
            table = restaurant.orderTable();
            notifyAll();
            System.out.println("Group " + number + " got table");
        }
        else
        {
            while(presentCount < memberCount)wait();
        }
        return table;
    }

    public synchronized void leaveTable() throws InterruptedException
    {
        presentCount--;
        if(presentCount == 0)
        {
            System.out.println("Group " + number + " freed table");
            restaurant.returnTable(table);
        }
    }

    public int getNumber()
    {
        return number;
    }
}
