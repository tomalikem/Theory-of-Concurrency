public class Writer extends Thread
{
    PrintersManager manager;
    int number;

    Writer(PrintersManager manager, int number)
    {
        this.manager = manager;
        this.number = number;
    }

    public void run()
    {
        for(int i = 1; i< 10; i++)
        {
            try
            {
                String text = String.valueOf(i) + "th novel by author " + String.valueOf(number);
                Printer printer = manager.takePrinter();
                printer.print(text);
                manager.returnPrinter(printer);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
