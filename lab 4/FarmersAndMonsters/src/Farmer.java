public class Farmer extends Thread
{
    int amount;
    Warehouse warehouse;
    Simulation simulation;

    boolean stored = false;
    long startTime;
    long endTime;

    Farmer(int amount, Warehouse warehouse, Simulation simulation)
    {
        this.amount = amount;
        this.warehouse = warehouse;
        this.simulation = simulation;
    }

    public void run()
    {
        startTime = System.currentTimeMillis();
        synchronized (warehouse)
        {
            try
            {
                while(!stored)
                {
                    if(warehouse.canStore(amount))
                    {
                        endTime = System.currentTimeMillis();
                        warehouse.store(amount);
                        stored = true;
                        sleep(1);
                        warehouse.notifyAll();
                    }
                    else
                    {
                        warehouse.wait();
                    }

                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        simulation.putFarmerTime(amount, (int)(endTime - startTime));
    }
}
