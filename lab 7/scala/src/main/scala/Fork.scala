import java.util.concurrent.locks.ReentrantLock


class Fork {
  val lock = new ReentrantLock
  protected var taken = false

  def take(): Unit = {
    taken = true
    lock.lock()
  }

  def putBack(): Unit = {
    lock.unlock()
    taken = false
  }

  def isTaken: Boolean = taken
}

