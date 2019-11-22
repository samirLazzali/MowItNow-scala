class Mower(private var x: Int, private var y: Int, private var orientation: Char) {

  // lazy
  // var : variable strong type, val : const
  def moveRight(): Unit = {
    orientation = orientation match {
      case 'N' => 'E'
      case 'E' => 'S'
      case 'W' => 'N'
      case 'S' => 'W'
      case _ => 'N' // TODO Throw error
    }
  }

  def moveLeft(): Unit = {
    orientation = orientation match {
      case 'N' => 'W'
      case 'E' => 'N'
      case 'W' => 'S'
      case 'S' => 'E'
      case _ => 'N' // TODO Throw error
    }
  }

  def canMoveForward(): (Int, Int) = {
    orientation match {
      case 'N' => (x, y + 1)
      case 'E' => (x + 1, y)
      case 'W' => (x - 1, y)
      case 'S' => (x, y - 1)
    }
  }

  def moveForward(): Unit = {
    orientation match {
      case 'N' => y += 1
      case 'E' => x += 1
      case 'W' => x -= 1
      case 'S' => y -= 1
    }
  }

  def getCoord(): (Int, Int) = {
    (x, y)
  }

  override def toString: String = {
    "(" + x + "," + y + ") " + orientation
  }
}

