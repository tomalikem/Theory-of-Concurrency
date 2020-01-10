class NaivePhilosopher(val number: Int, val f1: Fork, val f2: Fork)
  extends Philosopher(number, f1, f2)
{

  @throws[InterruptedException]
  override protected def eat(): Unit = {
    super.consume(f1, f2)
  }
}
