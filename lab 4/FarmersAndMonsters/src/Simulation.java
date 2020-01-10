import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Simulation
{
    Random rand  = new Random();

    ArrayList<MeasuringGroup> farmerCategories = new ArrayList<>();
    ArrayList<MeasuringGroup> monsterCategories = new ArrayList<>();
    Warehouse warehouse;
    int taskCount;
    int portionMaxSize;

    Simulation(Warehouse warehouse, int taskCount)
    {
        this.warehouse = warehouse;
        this.taskCount = taskCount;
        this.portionMaxSize = warehouse.capacity / 2;
        for(int i = 0; i < 10; i++)
        {
            farmerCategories.add(new MeasuringGroup(i * portionMaxSize + 1, (i+1) * portionMaxSize));
            monsterCategories.add(new MeasuringGroup(i * portionMaxSize + 1, (i+1) * portionMaxSize));
        }
    }

    public void simulate()
    {
        LinkedList<Thread> threads = new LinkedList<>();

        while(taskCount > 0)
        {
            taskCount--;
            int amount = Math.abs(rand.nextInt());
            amount = amount % portionMaxSize;
            threads.add(new Farmer(amount, warehouse, this));
            threads.add(new Monster(amount, warehouse, this));
        }

        for(Thread thread: threads)
        {
            thread.start();
        }

        for(Thread thread: threads)
        {
            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("   Farmers      Monsters   ");
        for(int i = 0 ; i < farmerCategories.size(); i++)
        {
            System.out.println(farmerCategories.get(i).mean() + "   " + monsterCategories.get(i).mean());
        }

    }

    public void putFarmerTime(int amount, int time)
    {
        int category = (10 * amount - 1) / portionMaxSize;
        farmerCategories.get(category).add(time);
    }

    public void putMonsterTime(int amount, int time)
    {
        int category = (10 * amount - 1) / portionMaxSize;
        monsterCategories.get(category).add(time);
    }
}
