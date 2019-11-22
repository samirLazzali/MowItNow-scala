

class Lawn(private val n: Int, private val m: Int, private val instructions: List[(Mower, String)], val display: Boolean = true) {


  // Comme il faut verifier que les déplacements sont bien dans le rectangle (qui ne dépend pas de la tondeuse)
  // et que les deplacements sont propre à une pelouse,
  // les tondeuses ont été créer indépendament (sans connaitre la taille de la pelouse ou la squence de déplacement)
  // De ce fait on pourra verfier chaque déplacement
  // enfin, instruction apaire une tondeuse à un sequence

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

  def playSequence(mower: Mower, move: Char): Unit = {
    // println("before move : " +mower.toString)
    if(display){
      print(mower.toString() + " + ")
    }
    move match {
      case 'G' => mower.moveLeft()
      case 'D' => mower.moveRight()
      case 'A' => moveForward(mower)
    }
    if (display) {
      println(move + " = " + mower.toString())
      displayLawn()
    }
  }

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

  def moveForward(mower: Mower): Unit = {
    if (authorize(mower)) {
      mower.moveForward()
    }
  }

  // verifier qu'on est dans la pelouse
  // et que les tondeuses n'entre pas en collision
  // à lancer une fois au début aussi !
  def authorize(mower: Mower): Boolean = {
    val coord = mower.canMoveForward()
    val x = coord._1
    val y = coord._2
    // println("actual coord : " + mower.getCoord())
    // println("next coord :  "+coord)

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

}