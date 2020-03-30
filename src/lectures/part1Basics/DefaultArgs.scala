package lectures.part1Basics

object DefaultArgs extends App {

  def tailRecFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else tailRecFact(n-1, n * acc)
  }

  val fact10 = tailRecFact(10)
  println(fact10)

  def savePic(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture!")

  savePic()
  savePic(width = 800)
  /*
    1. Pass in every leading argument
    2. Name the arguments
   */

  savePic(height = 600, width = 300, format = "png")
  

}
