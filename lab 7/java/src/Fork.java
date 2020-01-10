import java.util.concurrent.locks.ReentrantLock;

public class Fork
{
    ReentrantLock lock = new ReentrantLock();
    protected boolean taken = false;
    public void take()
    {
        taken = true;
        lock.lock();
    }

    public void putBack()
    {
        lock.unlock();
        taken = false;
    }

    public boolean isTaken()
    {
        return taken;
    }
}
