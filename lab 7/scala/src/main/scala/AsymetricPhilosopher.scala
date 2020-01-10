class AsymetricPhilosopher(val number: Int, val f1: Fork, val f2: Fork)
  extends Philosopher(number, f1, f2)
{

  @throws[InterruptedException]
  override protected def eat(): Unit = {
    if (number % 2 == 0) consume(f1, f2)
    else consume(f2, f1)
  }
}
