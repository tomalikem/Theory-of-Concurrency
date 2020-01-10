import java.util

import scala.collection.mutable.ListBuffer


object Main {
  def main(args: Array[String]): Unit =
  {
    val n = 7
        val philosophers = new ListBuffer[Philosopher]
        val forks = new ListBuffer[Fork]
        for {i <- 0 to n} forks += (new Fork)
        for (i <- 0 to n)philosophers += (new AsymetricPhilosopher(i, forks(i % n), forks((i + 1) % n)))
        val simulation = new Simulation(philosophers)
        val result = simulation.simulate
        System.out.println(result)


  }
}
