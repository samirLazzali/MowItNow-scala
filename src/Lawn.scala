class Lawn(private val n: Int, private val m: Int, private val instructions: List[(Mower, String)], val display: Boolean = false) {

  /**
   * playInstructions boucle sur les instructions
   * afin de jouer les sequences une par unes
   */
  def playInstructions(): Unit = {
    instructions.foreach(instruction => {
      val sequence: String = instruction._2
      val mower: Mower = instruction._1
      sequence.foreach(currentMove => {
        playSequence(mower: Mower, currentMove: Char)
      })
      println("Final coord : " + mower.toString)
      println("\n")
    })
  }

  /**
   * Effectue le deplacement pour une tendeuse
   *
   * @param mower
   * @param move
   */
  def playSequence(mower: Mower, move: Char): Unit = {
    if (display) {
      print(mower.toString() + " + ")
    }
    move match {
      case 'G' => mower.moveLeft()
      case 'D' => mower.moveRight()
      case 'A' => moveForward(mower)
      case _ => println(move + " : skipped unknown instruction")
    }
    if (display) {
      println(move + " = " + mower.toString())
      displayLawn()
    }
  }

  /**
   * Deplacement vers l'avant si le deplacement
   * est authorisé
   *
   * @param mower
   */
  def moveForward(mower: Mower): Unit = {
    if (authorize(mower)) {
      mower.moveForward()
    }
  }


  /**
   * Verifie qu'on est dans la pelouse
   * et que les tondeuses n'entrent pas en collision
   *
   * @param mower
   * @return Boolean
   */
  def authorize(mower: Mower): Boolean = {
    val coord = mower.canMoveForward()
    val x = coord._1
    val y = coord._2

    if (x < 0 | x > n | y < 0 | y > m) {
      println("Oups, stay on the lawn ! (move aborted) ")
      return false
    }

    instructions.foreach(instruction => {
      val coordLawn = instruction._1.getCoord()
      val xLawn = coordLawn._1
      val yLawn = coordLawn._2
      if (x == xLawn && y == yLawn) {
        println("Oups, a mower is allready here ! (move aborted) ")
        return false
      }
    })
    true
  }

  /**
   * Affiche une grille N x M avec les mower identifé par leur indice
   */
  def displayLawn(): Unit = {
    var coords: List[(Int, Int)] = List()
    instructions.foreach(instruction => {
      val coordLawn = instruction._1.getCoord()
      val xLawn = coordLawn._1
      val yLawn = coordLawn._2
      coords = coords :+ ((xLawn, yLawn))
    })
    for (y <- n to 0 by -1) {
      for (x <- 0 to m) {
        if (coords.contains((x, y))) {
          print(" " + coords.indexOf((x, y)) + " ")
        } else {
          print(" . ")
        }
      }
      println()
    }
    println()
  }
}