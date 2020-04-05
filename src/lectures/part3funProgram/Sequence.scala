package lectures.part3funProgram

import scala.util.Random

object Sequence extends App {

  // Seq
  val aSequence = Seq(1,2,3,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10 // 1 until 11
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  // List
  val aList = List(1,2,3)
  val prepended = 42 :: aList
  println(prepended)
  val prepap = 42 +: aList :+ 24
  println(prepap)

  val apples5 = List.fill(5)("apple")
  println(apples5)

  println(aList.mkString("-!-"))

  // Arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)
  println(threeElements)
  threeElements.foreach(println)
  val elementsStr = Array.ofDim[String](3)
  elementsStr.foreach(println)

  // mutation. Arrays can be mutated in place
  numbers(2) = 0 // syntax sugar for numbers.update(0)
  println(numbers.mkString(" "))

  // arrays and sequences
  val numbersSeq: Seq[Int] = numbers // implicit conversion. Very complicated boy!
  println(numbersSeq)
  // WrappedArray!

  // Vectors. It's own world
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // Vectors VS List

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      iter <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  // keeps reference t tail
  // updating the element in the middle takes long
  val numList = (1 to maxCapacity).toList
  // depth of the tree is small
  // needs to replace entire 32-element chunk
  val numVector = (1 to maxCapacity).toVector

  println(getWriteTime(numList))
  println(getWriteTime(numVector))
}
