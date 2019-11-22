object Main extends App {

  // pour une taille de 5x5 on a en réalité une grille de 6x6
  // car 0,0 est inclu
  //val lawn = new Lawn(5,5)
  //println(lawn.instructions(0))

  val bufferedSource = io.Source.fromResource("instructions.txt")
  val lines = bufferedSource.getLines()

  // read first line
  val coordTopRight: String = lines.next()
  val xTopRight = coordTopRight.split(" ")(0).toInt
  val yTopRight = coordTopRight.split(" ")(1).toInt

  var instructions: List[(Mower, String)] = List()

  while (lines.hasNext) {
    val moverArray = lines.next().split(" ")
    val mower: Mower = new Mower(moverArray(0).toInt, moverArray(1).toInt, moverArray(2).charAt(0))
    val sequenceString = lines.next()
    instructions = instructions :+ (mower, sequenceString)
  }
  bufferedSource.close

  println("\nInstructions : " + instructions+"\n")
  val lawn = new Lawn(xTopRight, yTopRight, instructions, false)
  lawn.playInstructions()
}
