package lectures.part1Basics

object CBNvsCBV extends App {

  def callByName(x: => Long): Unit = {
    println("by name " + x)
    println("by name " + x)
  }

  def callByValue(x: Long): Unit = {
    println("by value " + x)
    println("by value " + x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

  // printFirst(infinite(), 34)
  printFirst(34, infinite())

}
