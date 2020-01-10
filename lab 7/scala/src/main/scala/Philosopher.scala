import java.util.Random

abstract class Philosopher(number: Int, f1: Fork, f2: Fork) extends Thread {
  val rand: Random = new Random
  var waitingTime = 0
  var waitingCount = 0
  var startedWaiting = 0
  var finishedWaiting = 0

  override def run(): Unit = {
    try {
      var i: Int = 0
      while ( {
        i < 100
      }) {
        think()
        startedWaiting = System.currentTimeMillis.toInt
        eat()

        {
          i += 1; i - 1
        }
      }
    } catch {
      case e: InterruptedException =>
        e.printStackTrace()
    }
  }

  @throws[InterruptedException]
  private def think(): Unit = {
    Thread.sleep(Math.abs(rand.nextInt) % 100)
  }

  @throws[InterruptedException]
  protected def eat(): Unit

  @throws[InterruptedException]
  protected def consume(f1: Fork, f2: Fork): Unit = {
    f1.take()
    Thread.sleep(1)
    f2.take()
    finishedWaiting = System.currentTimeMillis.toInt
    waitingCount += 1
    waitingTime = waitingTime + finishedWaiting - startedWaiting
    Thread.sleep(Math.abs(rand.nextInt) % 100)
    f1.putBack()
    f2.putBack()
  }
}

