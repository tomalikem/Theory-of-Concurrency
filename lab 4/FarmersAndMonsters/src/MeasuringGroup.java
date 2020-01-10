public class MeasuringGroup
{
    private int minSize;
    private int maxSize;
    private int time = 0;
    private int count = 0;

    MeasuringGroup(int minSize, int maxSize)
    {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    public void add(int time)
    {
        this.time += time;
        count++;
    }

    public String mean()
    {
        if(count > 0) return minSize + " - " + maxSize + ": " + time / count;
        else return minSize + " - " + maxSize + ": *";
    }
}
