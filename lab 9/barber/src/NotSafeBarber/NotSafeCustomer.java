package NotSafeBarber;

public class NotSafeCustomer extends Thread
{
    public boolean gotHaircut;
    NotSafeShop shop;
    int count;
    int number;

    public NotSafeCustomer(NotSafeShop shop, int count, int number)
    {
        this.shop = shop;
        this.count = count;
        this.number = number;
    }

    public void run()
    {
        try
        {
            for(int i = 0; i< count; i++)
            {
                if(shop.canSit())
                {
                    shop.addCustomer(this);
                    getHaircut();
                }
                else {
                    giveUp();
                    i--;
                }
            }
        }
        catch (Exception e)
        {
        }

    }

    public void getHaircut() throws InterruptedException
    {
        gotHaircut = false;
        System.out.println("Customer " + number + " is getting haircut");
        while(!gotHaircut)
        {
            Thread.sleep(1);
        }
    }

    public void giveUp() throws InterruptedException
    {
        System.out.println("Customer " + number + " leaved - no free chairs.");
        Thread.sleep(20);
    }

    public int getNumber()
    {
        return this.number;
    }

}
