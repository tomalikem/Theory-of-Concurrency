class Table(var size: Int) {
  this.currentlyEating = 0
  private var currentlyEating = 0
  var waits = false

  def canStartEating: Boolean = currentlyEating < size

  def startEating(): Unit = {
    currentlyEating += 1
  }

  def finishEating(): Unit = {
    currentlyEating -= 1
  }
}

