public class Monster extends Thread
{
    int amount;
    Warehouse warehouse;
    Simulation simulation;

    boolean eaten = false;
    long startTime;
    long endTime;

    Monster(int amount, Warehouse warehouse, Simulation simulation)
    {
        this.amount = amount;
        this.warehouse = warehouse;
        this.simulation = simulation;
    }

    public void run()
    {
        synchronized (warehouse)
        {
            try
            {
                startTime = System.currentTimeMillis();
                while(!eaten)
                {
                    if(warehouse.canEat(amount))
                    {
                        endTime = System.currentTimeMillis();
                        warehouse.eat(amount);
                        eaten = true;
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
        simulation.putMonsterTime(amount, (int)(endTime - startTime));
    }

}