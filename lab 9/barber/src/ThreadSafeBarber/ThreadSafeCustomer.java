package ThreadSafeBarber;

public class ThreadSafeCustomer extends Thread
{
    private boolean sleeps = false;
    ThreadSafeShop shop;
    int count;
    int number;

    public ThreadSafeCustomer(ThreadSafeShop shop, int count, int number)
    {
        this.shop = shop;
        this.count = count;
        this.number = number;
    }

    public void run()
    {
        synchronized (this)
        {
            try
            {
                for(int i = 0; i< count; i++)
                {
                    if(shop.canSit())
                    {
                        shop.addCustomer(this);
                        wait();
                        getHaircut();
                    }
                    else
                    {
                        giveUp();
                        i--;
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void getHaircut() throws InterruptedException
    {
        System.out.println("Customer " + number + " is getting haircut");
        this.wait();
    }

    public void giveUp() throws InterruptedException
    {
        System.out.println("Customer " + number + " leaved - no free chairs.");
        Thread.sleep(2000);
    }

    public int getNumber()
    {
        return this.number;
    }

}
