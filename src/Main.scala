object Main extends App {

  /*
  Ouverture du fichier
   */
  val bufferedSource = io.Source.fromResource("instructions.txt")
  val lines = bufferedSource.getLines()

  /*
  Initialisation des variables
   */
  var instructions: List[(Mower, String)] = List()
  var xTopRight = -1
  var yTopRight = -1

  /*
  (Pour une taille de 5x5 on a en réalité une grille de 6x6 car 0,0 est inclu)
  Récuperation de la premier ligne qui contient les coordonées de la grille
   */
  val coordTopRight: String = lines.next()
  /*
  Lecture des lignes une à une afin créer les mowers et les associer à leurs sequence
  dans la liste instructions
   */
  try {
    xTopRight = coordTopRight.split(" ")(0).toInt
    yTopRight = coordTopRight.split(" ")(1).toInt
    while (lines.hasNext) {
      val moverArray = lines.next().split(" ")
      val mower: Mower = new Mower(moverArray(0).toInt, moverArray(1).toInt, moverArray(2).charAt(0))
      val sequenceString = lines.next()
      instructions = instructions :+ (mower, sequenceString)
    }
    bufferedSource.close
    println("\nInstructions : " + instructions + "\n")
  } catch {
    case _: Exception => {
      println("Oups, error on file reading")
      System.exit(0)
    }
  }

  if (xTopRight > 0 && yTopRight > 0) {
    /*
    Lawn est ici initialisé en un coup avec tout les parametres.
    Il aurait pu etre interessant de l'init petit a petit
     */
    val lawn = new Lawn(xTopRight, yTopRight, instructions, true)
    lawn.playInstructions()
  } else {
    println("Oups, lawn coord not valid")
  }


}
