import scala.collection.mutable.ListBuffer


class Simulation(var philosophers: ListBuffer[Philosopher]) {
  var average = 0
  var max = 0
  var min = Int.MaxValue

  def simulate: String = {
    var result = ""
    try {
      for (philosopher <- philosophers) {
        philosopher.start()
      }
      for (philosopher <- philosophers) {
        philosopher.join()
      }
      for (philosopher <- philosophers) {
        val time = philosopher.waitingTime / philosopher.waitingCount
        average = average + time / philosophers.size
        max = Math.max(max, time)
        min = Math.min(min, time)
      }
      result = " " + average
    } catch {
      case e: InterruptedException =>
        e.printStackTrace()
    }
    result
  }
}
