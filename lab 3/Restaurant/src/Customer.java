public class Customer extends Thread
{
    private int number;
    private Group group;
    private Table table;

    Customer(Group group, int number)
    {
        this.group = group;
        group.addMember();
        this.number = number;
    }

    public void run()
    {
        try
        {
            table = group.orderTable();
            table.eat("Customer: " + number + " from group " + group.getNumber());
            group.leaveTable();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
