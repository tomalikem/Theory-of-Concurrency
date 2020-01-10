class ArbitrousPhilosopher(val number: Int, val f1: Fork, val f2: Fork, val table: Table)
  extends Philosopher(number, f1, f2)
{
  @throws[InterruptedException]
  override protected def eat(): Unit = {
    table synchronized
    {
      if (!table.canStartEating) {
        table.waits = true
        wait()
      }
      table.startEating()
      consume(f1, f2)
      table.finishEating()
      if (table.waits) notify()
    }

  }
}

