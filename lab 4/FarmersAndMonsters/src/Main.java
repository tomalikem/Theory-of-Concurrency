public class Main
{
    public static void main(String[] args)
    {
        int capacity = 1000;
        int taskCount = 1000;

        Warehouse warehouse = new SmartWarehouse(capacity);

        Simulation simulation = new Simulation(warehouse, taskCount);

        simulation.simulate();
    }

}
