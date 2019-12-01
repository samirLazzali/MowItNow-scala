class Mower(private var x: Int, private var y: Int, private var orientation: Char) {

  /**
   * Effectue une orientation vers la droite
   */
  def moveRight(): Unit = {
    orientation = orientation match {
      case 'N' => 'E'
      case 'E' => 'S'
      case 'W' => 'N'
      case 'S' => 'W'
    }
  }

  /**
   * Effectue une orientation vers la gauche
   */
  def moveLeft(): Unit = {
    orientation = orientation match {
      case 'N' => 'W'
      case 'E' => 'N'
      case 'W' => 'S'
      case 'S' => 'E'
    }
  }

  /**
   * Retourne les future coordonnées d'un déplacement tout droit
   * en fonction de l'orientation
   * (Sans rien modifier)
   */
  def canMoveForward(): (Int, Int) = {
    orientation match {
      case 'N' => (x, y + 1)
      case 'E' => (x + 1, y)
      case 'W' => (x - 1, y)
      case 'S' => (x, y - 1)
    }
  }

  /**
   * Modification des coordonnées pour un déplacement tout droit
   */
  def moveForward(): Unit = {
    orientation match {
      case 'N' => y += 1
      case 'E' => x += 1
      case 'W' => x -= 1
      case 'S' => y -= 1
    }
  }

  /**
   * Retourne les coordonnées de la tondeuse
   *
   * @return (Int, Int)
   */
  def getCoord(): (Int, Int) = {
    (x, y)
  }

  /**
   * to String de la tondeuse
   *
   * @return String
   */
  override def toString: String = {
    "(" + x + "," + y + ") " + orientation
  }
}

