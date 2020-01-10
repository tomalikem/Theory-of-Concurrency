class StarvingPhilosopher(val number: Int, val f1: Fork, val f2: Fork, val table: Table)
  extends Philosopher(number, f1, f2)
{

  @throws[InterruptedException]
  override protected def eat(): Unit = {
    table synchronized
    {
      while ( {
        f1.isTaken || f2.isTaken
      }) {
        table.waits = true
        table.wait()
      }
      consume(f1, f2)
      if (table.waits) {
        table.waits = false
        table.notifyAll()
      }
    }
  }
}
